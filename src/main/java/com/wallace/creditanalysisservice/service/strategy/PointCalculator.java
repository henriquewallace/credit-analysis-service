package com.wallace.creditanalysisservice.service.strategy;

import com.wallace.creditanalysisservice.domain.Proposal;

public interface PointCalculator {

    int calculate(Proposal proposal);
}
