package com.zhaolearn.rabbitmqnormal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MessageProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageProvider.class);
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String i) {
        Date date = new Date();
        String msg = "RabbitMQ普通模式,第"+i+"次发送"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        LOGGER.info("普通模式数据组装完成" + msg);
        this.rabbitTemplate.convertAndSend(QueueEnum.MESSAGE_QUEUE_NORMAL.getQueueName(), msg);
    }
}
