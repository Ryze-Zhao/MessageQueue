package com.zhaolearn.rabbitmqconsumer.rabbitmq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 这个类作为消费者
 *
 * @author: HeHaoZhao
 * @date: 2019/1/16 11:00
 */
@Component
@RabbitListener(queues = "message.rabbit.queue.topic.c")
public class TopicQueueC {
    private final static Logger LOGGER = LoggerFactory.getLogger(TopicQueueC.class);

    @RabbitHandler
    public void handler(String content) {
        LOGGER.info("读取Queue内容：{}", content);
    }
}

