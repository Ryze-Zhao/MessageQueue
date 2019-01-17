package com.zhaolearn.rabbitmqnormal;

public enum QueueEnum {
    /**
     * 消息通知队列
     */
    MESSAGE_QUEUE_NORMAL("message.rabbit.queue.name","message.rabbit.queue.exchange","message.rabbit.queue.key");

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
