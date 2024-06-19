package com.wallace.creditanalysisservice.service;

import com.wallace.creditanalysisservice.domain.Proposal;
import com.wallace.creditanalysisservice.exceptions.StrategyException;
import com.wallace.creditanalysisservice.service.strategy.PointCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAnalysisService {

    @Value("${rabbitmq.finishedproposal.exchange}")
    private String finishedProposalExchange;

    private final List<PointCalculator> pointCalculatorList;
    private final NotificationRabbitService notificationRabbitService;

    public CreditAnalysisService(List<PointCalculator> pointCalculatorList,
                                 NotificationRabbitService notificationRabbitService) {
        this.pointCalculatorList = pointCalculatorList;
        this.notificationRabbitService = notificationRabbitService;
    }


    public void analyze(Proposal proposal) {
        try {
            int score = pointCalculatorList.stream()
                    .mapToInt(impl -> impl.calculate(proposal)).sum();

            proposal.setApproved(score > 350);
        } catch (StrategyException ex) {
            proposal.setApproved(false);
            proposal.setObservation(ex.getMessage());
        }

        notificationRabbitService.notify(finishedProposalExchange, proposal);
    }
}
