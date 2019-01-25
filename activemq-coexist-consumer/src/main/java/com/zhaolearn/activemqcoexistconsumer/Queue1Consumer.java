package com.zhaolearn.activemqcoexistconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class Queue1Consumer {
    private final static Logger LOGGER = LoggerFactory.getLogger(Queue1Consumer.class);
    @JmsListener(destination = "message.queue.enum.name", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(String text) { LOGGER.info("Queue1Consumer接收到："+text); }
}