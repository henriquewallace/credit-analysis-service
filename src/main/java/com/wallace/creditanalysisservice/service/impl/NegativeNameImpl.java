package com.wallace.creditanalysisservice.service.impl;

import com.wallace.creditanalysisservice.contants.ConstantMessages;
import com.wallace.creditanalysisservice.domain.Proposal;
import com.wallace.creditanalysisservice.exceptions.StrategyException;
import com.wallace.creditanalysisservice.service.strategy.PointCalculator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order
@Component
public class NegativeNameImpl implements PointCalculator {

    @Override
    public int calculate(Proposal proposal) {
        if (negativeName()) {
            throw new StrategyException(String.format(ConstantMessages.NEGATIVATED_CLIENT, proposal.getUser().getName()));
        }

        return 100;
    }

    private boolean negativeName() {
        return new Random().nextBoolean();
    }
}
