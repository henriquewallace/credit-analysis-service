package com.wallace.creditanalysisservice.listener;

import com.wallace.creditanalysisservice.domain.Proposal;
import com.wallace.creditanalysisservice.service.CreditAnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreditAnalysisListener {

    private final CreditAnalysisService creditAnalysisService;

    @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
    public void creditAnalysis(@Payload Proposal proposal) {
        creditAnalysisService.analyze(proposal);
    }
}
