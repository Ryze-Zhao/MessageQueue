package com.zhaolearn.rabbitmqfanout;

/**
 *
 *
 * @param null
 * @return:
 * @author: HeHaoZhao
 * @date: 2019/1/17 17:30
 */
public enum QueueEnum {
    //定义Exchange
    MESSAGE_EXCHANGE_FANOUT("","message.rabbit.queue.fanout.exchange",""),
    //消息通知队列
    MESSAGE_QUEUE_FANOUTA("message.rabbit.queue.fanout.a",MESSAGE_EXCHANGE_FANOUT.getExchange(),""),
    MESSAGE_QUEUE_FANOUTB("message.rabbit.queue.fanout.b",MESSAGE_EXCHANGE_FANOUT.getExchange(),""),
    MESSAGE_QUEUE_FANOUTC("message.rabbit.queue.fanout.c",MESSAGE_EXCHANGE_FANOUT.getExchange(),"");

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
