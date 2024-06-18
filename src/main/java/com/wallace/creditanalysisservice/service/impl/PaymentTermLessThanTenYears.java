package com.wallace.creditanalysisservice.service.impl;

import com.wallace.creditanalysisservice.domain.Proposal;
import com.wallace.creditanalysisservice.service.strategy.PointCalculator;

public class PaymentTermLessThanTenYears implements PointCalculator {

    @Override
    public int calculate(Proposal proposal) {
        return proposal.getPaymentTerm() < 120 ? 80 : 0;
    }
}
