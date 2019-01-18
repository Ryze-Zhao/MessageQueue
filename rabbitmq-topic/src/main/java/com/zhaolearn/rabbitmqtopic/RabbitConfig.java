package com.zhaolearn.rabbitmqtopic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //定义一个Exchange
    @Bean
    TopicExchange topicExchange() {
        // 定义一个名为MESSAGE_EXCHANGE_TOPIC.getExchange()的topic交换器
        return new TopicExchange(QueueEnum.MESSAGE_EXCHANGE_TOPIC.getExchange());
    }
    //定义多个Queue
    @Bean
    public Queue topicQueueA() { return new Queue(QueueEnum.MESSAGE_QUEUE_TOPICA.getQueueName()); }
    @Bean
    public Queue topicQueueB() { return new Queue(QueueEnum.MESSAGE_QUEUE_TOPICB.getQueueName()); }
    @Bean
    public Queue topicQueueC() { return new Queue(QueueEnum.MESSAGE_QUEUE_TOPICC.getQueueName()); }
    //将Queue绑定到Exchange
    @Bean
    public Binding bindingExchangeWithQueueA() {
        return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with(QueueEnum.MESSAGE_QUEUE_TOPICA.getRouteKey());
    }
    @Bean
    public Binding bindingExchangeWithQueueB() {
        return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with(QueueEnum.MESSAGE_QUEUE_TOPICB.getRouteKey());
    }
    @Bean
    public Binding bindingExchangeWithQueueC() {
        return BindingBuilder.bind(topicQueueC()).to(topicExchange()).with(QueueEnum.MESSAGE_QUEUE_TOPICC.getRouteKey());
    }
}