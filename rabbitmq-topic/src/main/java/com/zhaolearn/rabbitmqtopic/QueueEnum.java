package com.zhaolearn.rabbitmqtopic;

/**
 *
 * @author: HeHaoZhao
 * @date: 2019/1/17 17:30
 */
public enum QueueEnum {
    //定义Exchange
    MESSAGE_EXCHANGE_TOPIC("","message.rabbit.queue.topic.exchange",""),
    //这个其实跟Direct一样
    MESSAGE_QUEUE_TOPICA("message.rabbit.queue.topic.a",MESSAGE_EXCHANGE_TOPIC.getExchange(),"message.rabbit.queue.topic.msg"),
    //*号匹配为一个词
    MESSAGE_QUEUE_TOPICB("message.rabbit.queue.topic.b",MESSAGE_EXCHANGE_TOPIC.getExchange(),"message.rabbit.queue.topic.*"),
    //#号匹配为一个词或多个词
    MESSAGE_QUEUE_TOPICC("message.rabbit.queue.topic.c",MESSAGE_EXCHANGE_TOPIC.getExchange(),"message.rabbit.queue.topic.#");

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
