package com.zhaolearn.activemqcoexistconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class QueueConsumer {
    private final static Logger LOGGER = LoggerFactory.getLogger(QueueConsumer.class);
    @JmsListener(destination ="message.queue.enum.name" , containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(String text) {
        LOGGER.info("QueueConsumer接收到："+text);
    }
}