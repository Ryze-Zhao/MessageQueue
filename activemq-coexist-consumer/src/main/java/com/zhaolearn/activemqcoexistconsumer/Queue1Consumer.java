package com.zhaolearn.activemqcoexistconsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class Queue1Consumer {
    @JmsListener(destination = "message.queue.enum.name", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(String text) {
        System.out.println("Queue1Consumer接收到："+text);
    }
}