package com.wallace.creditanalysisservice.service.impl;

import com.wallace.creditanalysisservice.domain.Proposal;
import com.wallace.creditanalysisservice.service.strategy.PointCalculator;
import org.springframework.stereotype.Component;

@Component
public class IncomeGreaterThanRequestedValueImpl implements PointCalculator {

    @Override
    public int calculate(Proposal proposal) {
        return incomeGreaterThanRequestedValue(proposal) ? 100 : 0;
    }

    private boolean incomeGreaterThanRequestedValue(Proposal proposal) {
        return proposal.getUser().getIncome() > proposal.getRequestedAmount();
    }
}
