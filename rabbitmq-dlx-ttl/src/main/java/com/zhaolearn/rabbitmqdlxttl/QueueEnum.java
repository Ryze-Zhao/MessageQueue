package com.zhaolearn.rabbitmqdlxttl;

public enum QueueEnum {

    MESSAGE_QUEUE("message.center.queue.normal","message.center.exchange.normal","message.center.key.normal"),
    MESSAGE_TTL_QUEUE("message.center.queue.ttl","message.center.exchange.ttl", "message.center.key.ttl");

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
