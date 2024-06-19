package com.wallace.creditanalysisservice.service;

import com.wallace.creditanalysisservice.domain.Proposal;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationRabbitService {

    private final RabbitTemplate rabbitTemplate;

    public NotificationRabbitService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void notify(String exchange, Proposal proposal) {
        rabbitTemplate.convertAndSend(exchange, "", proposal);
    }
}
