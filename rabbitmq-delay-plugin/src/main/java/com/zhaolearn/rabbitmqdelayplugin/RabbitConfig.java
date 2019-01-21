package com.zhaolearn.rabbitmqdelayplugin;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfig {
    //定义一个Exchange
    @Bean
    CustomExchange delayPluginExchange() {
        // 定义一个名为MESSAGE_EXCHANGE_FANOUT.getExchange()的direct交换器
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(QueueEnum.MESSAGE_EXCHANGE_DELAY_PLUGIN.getExchange(),
                "x-delayed-message", true, false, args);
    }
    //定义多个Queue
    @Bean
    public Queue delayPluginQueue() {
        return new Queue(QueueEnum.MESSAGE_EXCHANGE_DELAY_PLUGIN.getQueueName(),true);
    }

    //将Queue绑定到Exchange
    @Bean
    public Binding delayPluginBinding() {
        return BindingBuilder.bind(delayPluginQueue()).to(delayPluginExchange()).
                with(QueueEnum.MESSAGE_EXCHANGE_DELAY_PLUGIN.getRouteKey()).noargs();
    }
}