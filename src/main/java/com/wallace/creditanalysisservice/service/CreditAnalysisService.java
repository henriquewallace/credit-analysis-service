package com.wallace.creditanalysisservice.service;

import com.wallace.creditanalysisservice.domain.Proposal;
import com.wallace.creditanalysisservice.service.strategy.PointCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAnalysisService {

    private final List<PointCalculator> pointCalculatorList;

    public CreditAnalysisService(List<PointCalculator> pointCalculatorList) {
        this.pointCalculatorList = pointCalculatorList;
    }

    public void analyze(Proposal proposal) {
        boolean approved = pointCalculatorList.stream()
                .mapToInt(impl -> impl.calculate(proposal)).sum() > 350;
    }
}
