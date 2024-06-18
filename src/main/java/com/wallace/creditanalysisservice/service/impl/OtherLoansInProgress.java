package com.wallace.creditanalysisservice.service.impl;

import com.wallace.creditanalysisservice.domain.Proposal;
import com.wallace.creditanalysisservice.service.strategy.PointCalculator;

import java.util.Random;

public class OtherLoansInProgress implements PointCalculator {

    @Override
    public int calculate(Proposal proposal) {
        return otherLoansInProgress() ? 0 : 80;
    }

    private boolean otherLoansInProgress() {
        return new Random().nextBoolean();
    }
}
