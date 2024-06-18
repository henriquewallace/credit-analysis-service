package com.wallace.creditanalysisservice.listener;

import com.wallace.creditanalysisservice.domain.Proposal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CreditAnalysisListener {

    @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
    public void creditAnalysis(@Payload Proposal proposal) {

    }
}
