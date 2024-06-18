package com.wallace.creditanalysisservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CreditAnalysisListener {

    @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
    public void creditAnalysis() {

    }
}
