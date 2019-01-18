package com.zhaolearn.rabbitmqdirect;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //定义一个Exchange
    @Bean
    DirectExchange directExchange() {
        // 定义一个名为MESSAGE_EXCHANGE_FANOUT.getExchange()的direct交换器
        return new DirectExchange(QueueEnum.MESSAGE_EXCHANGE_DIRECT.getExchange());
    }
    //定义多个Queue
    @Bean
    public Queue directQueueA() { return new Queue(QueueEnum.MESSAGE_QUEUE_DIRECTA1.getQueueName()); }
    @Bean
    public Queue directQueueB() { return new Queue(QueueEnum.MESSAGE_QUEUE_DIRECTB1.getQueueName()); }

    //将Queue绑定到Exchange
    @Bean
    public Binding bindingExchangeWithQueueA() {
        return BindingBuilder.bind(directQueueA()).to(directExchange()).with(QueueEnum.MESSAGE_QUEUE_DIRECTA1.getRouteKey());
    }
    @Bean
    public Binding bindingExchangeWithQueueB1() {
        return BindingBuilder.bind(directQueueB()).to(directExchange()).with(QueueEnum.MESSAGE_QUEUE_DIRECTB1.getRouteKey());
    }
    @Bean
    public Binding bindingExchangeWithQueueB2() {
        return BindingBuilder.bind(directQueueB()).to(directExchange()).with(QueueEnum.MESSAGE_QUEUE_DIRECTB2.getRouteKey());
    }
}