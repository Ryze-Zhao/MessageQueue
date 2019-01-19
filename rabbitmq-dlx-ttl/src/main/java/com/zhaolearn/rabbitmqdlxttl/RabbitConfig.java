package com.zhaolearn.rabbitmqdlxttl;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfig {
    //定义Exchange，一个业务Exchange，一个死信Exchange
    @Bean
    DirectExchange normalDirectExchange() { return new DirectExchange(QueueEnum.MESSAGE_QUEUE.getExchange()); }
    @Bean
    DirectExchange ttlDirectExchange() { return new DirectExchange(QueueEnum.MESSAGE_TTL_QUEUE.getExchange()); }

    //定义,一个业务Queue，一个死信Queue
    @Bean
    public Queue normalQueue() { return new Queue(QueueEnum.MESSAGE_QUEUE.getQueueName()); }
    @Bean
    public Queue ttlQueue() {
        Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("x-dead-letter-exchange", QueueEnum.MESSAGE_QUEUE.getExchange()); // 配置到期后转发的交换
        arguments.put("x-dead-letter-routing-key", QueueEnum.MESSAGE_QUEUE.getRouteKey());// 配置到期后转发的交换Key
        return new Queue(QueueEnum.MESSAGE_TTL_QUEUE.getQueueName(),true,false,false,arguments);
    }
    //将Queue绑定到Exchange
    @Bean
    public Binding bindingExchangeWithNormalQueue() {
        return BindingBuilder.bind(normalQueue()).to(normalDirectExchange()).with(QueueEnum.MESSAGE_QUEUE.getRouteKey());
    }
    @Bean
    public Binding bindingExchangeWithTtlQueue() {
        return BindingBuilder.bind(ttlQueue()).to(ttlDirectExchange()).with(QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey());
    }
    /**
     * this.name = name;  //名称
     * this.durable = durable; //是否持久化
     * this.exclusive = exclusive; //是否排外（多个链接访问时，只能有一个进来）
     * this.autoDelete = autoDelete; //是否自动删除
     * this.arguments = arguments; //规则
     * //            Map<String, Object> arguments = new HashMap<String, Object>();
     * //            // 统一设置队列中的所有消息的过期时间
     * //            arguments.put("x-message-ttl", 30000);
     * //            // 设置超过多少毫秒没有消费者来访问队列，就删除队列的时间
     * //            arguments.put("x-expires", 20000);
     * //            // 设置队列的最新的N条消息，如果超过N条，前面的消息将从队列中移除掉
     * //            arguments.put("x-max-length", 4);
     * //            // 设置队列的内容的最大空间，超过该阈值就删除之前的消息
     * //            arguments.put("x-max-length-bytes", 1024);
     * //            // 将删除的消息推送到指定的交换机，一般x-dead-letter-exchange和x-dead-letter-routing-key需要同时设置
     * //            arguments.put("x-dead-letter-exchange", "exchange.dead");
     * //            // 将删除的消息推送到指定的交换机对应的路由键
     * //            arguments.put("x-dead-letter-routing-key", "routingkey.dead");
     * //            // 设置消息的优先级，优先级大的优先被消费
     * //            arguments.put("x-max-priority", 10);
     * @return
     */


}