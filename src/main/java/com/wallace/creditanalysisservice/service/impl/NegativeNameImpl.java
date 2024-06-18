package com.wallace.creditanalysisservice.service.impl;

import com.wallace.creditanalysisservice.domain.Proposal;
import com.wallace.creditanalysisservice.service.strategy.PointCalculator;

import java.util.Random;

public class NegativeNameImpl implements PointCalculator {

    @Override
    public int calculate(Proposal proposal) {
        if (negativeName()) {
            throw new RuntimeException("Negative name");
        }

        return 100;
    }

    private boolean negativeName() {
        return new Random().nextBoolean();
    }
}
