package com.zhaolearn.rabbitmqnormal;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue newNorMalQueue() {
        return new Queue(QueueEnum.MESSAGE_QUEUE_NORMAL.getQueueName());
    }
}