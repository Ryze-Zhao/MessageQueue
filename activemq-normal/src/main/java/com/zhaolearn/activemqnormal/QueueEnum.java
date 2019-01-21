package com.zhaolearn.activemqnormal;

/**
 *
 * @author: HeHaoZhao
 * @date: 2019/1/17 17:30
 */
public enum QueueEnum {
    //定义Exchange
    MESSAGE_Queue_NORMAL("message.queue.name","","");


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
