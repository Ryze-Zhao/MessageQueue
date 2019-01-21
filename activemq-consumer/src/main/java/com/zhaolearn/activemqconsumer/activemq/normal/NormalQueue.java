package com.zhaolearn.activemqconsumer.activemq.normal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class NormalQueue {
    private final static Logger LOGGER = LoggerFactory.getLogger(NormalQueue.class);
    @JmsListener(destination = "message.queue.name")
    public void receiveQueue(String msg) {
        LOGGER.info("获取消息："+msg);
    }
}