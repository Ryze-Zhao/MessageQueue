package com.zhaolearn.rabbitmqfanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //定义一个Exchange
    @Bean
    FanoutExchange fanoutExchange() {
        // 定义一个名为MESSAGE_EXCHANGE_FANOUT.getExchange()的fanout交换器
        return new FanoutExchange(QueueEnum.MESSAGE_EXCHANGE_FANOUT.getExchange());
    }
    //定义多个Queue
    @Bean
    public Queue fanoutQueueA() {
        return new Queue(QueueEnum.MESSAGE_QUEUE_FANOUTA.getQueueName());
    }
    @Bean
    public Queue fanoutQueueB() {
        return new Queue(QueueEnum.MESSAGE_QUEUE_FANOUTB.getQueueName());
    }
    @Bean
    public Queue fanoutQueueC() { return new Queue(QueueEnum.MESSAGE_QUEUE_FANOUTC.getQueueName()); }
    //将Queue绑定到Exchange
    @Bean
    public Binding bindingExchangeWithQueueA() {
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }
    @Bean
    public Binding bindingExchangeWithQueueB() {
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }
    @Bean
    public Binding bindingExchangeWithQueueC() {
        return BindingBuilder.bind(fanoutQueueC()).to(fanoutExchange());
    }
}