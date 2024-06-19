package com.wallace.creditanalysisservice.service.impl;

import com.wallace.creditanalysisservice.contants.ConstantMessages;
import com.wallace.creditanalysisservice.domain.Proposal;
import com.wallace.creditanalysisservice.exceptions.StrategyException;
import com.wallace.creditanalysisservice.service.strategy.PointCalculator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class ScorePointImpl implements PointCalculator {

    @Override
    public int calculate(Proposal proposal) {
        int score = score();

        if (score < 200) {
            throw new StrategyException(String.format(ConstantMessages.BAD_SCORE, proposal.getUser().getName()));
        } else if (score <= 400) {
            return 150;
        } else if (score <= 600) {
            return 180;
        } else {
            return 220;
        }
    }

    private int score() {
        return new Random().nextInt(0, 1000);
    }
}
