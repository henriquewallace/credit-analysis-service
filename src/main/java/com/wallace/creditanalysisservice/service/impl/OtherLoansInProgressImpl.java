package com.wallace.creditanalysisservice.service.impl;

import com.wallace.creditanalysisservice.domain.Proposal;
import com.wallace.creditanalysisservice.service.strategy.PointCalculator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtherLoansInProgressImpl implements PointCalculator {

    @Override
    public int calculate(Proposal proposal) {
        return otherLoansInProgress() ? 0 : 80;
    }

    private boolean otherLoansInProgress() {
        return new Random().nextBoolean();
    }
}
