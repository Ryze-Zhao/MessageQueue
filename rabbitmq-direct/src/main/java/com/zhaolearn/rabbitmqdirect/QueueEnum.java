package com.zhaolearn.rabbitmqdirect;

/**
 *
 * @author: HeHaoZhao
 * @date: 2019/1/17 17:30
 */
public enum QueueEnum {
    //定义Exchange
    MESSAGE_EXCHANGE_DIRECT("","message.rabbit.queue.direct.exchange",""),
    //消息通知队列
    MESSAGE_QUEUE_DIRECTA1("message.rabbit.queue.direct.a",MESSAGE_EXCHANGE_DIRECT.getExchange(),"message.rabbit.queue.direct.a"),
    MESSAGE_QUEUE_DIRECTB1("message.rabbit.queue.direct.b",MESSAGE_EXCHANGE_DIRECT.getExchange(),"message.rabbit.queue.direct.b1"),
    MESSAGE_QUEUE_DIRECTB2("message.rabbit.queue.direct.b",MESSAGE_EXCHANGE_DIRECT.getExchange(),"message.rabbit.queue.direct.b2");

    /**
     * 队列名称
     */
    private String queueName;
    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 路由键
     */
    private String routeKey;
    QueueEnum(String queueName, String exchange, String routeKey) {
        this.queueName = queueName;
        this.exchange = exchange;
        this.routeKey = routeKey;
    }

    public String getQueueName() {
        return queueName;
    }

    public String getExchange() {
        return exchange;
    }

    public String getRouteKey() {
        return routeKey;
    }
}
