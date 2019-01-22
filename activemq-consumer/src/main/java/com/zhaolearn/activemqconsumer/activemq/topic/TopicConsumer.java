package com.zhaolearn.activemqconsumer.activemq.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class TopicConsumer {
    @JmsListener(destination = "message.topic.enum.name")
    public void receiveQueue(String text) {
        System.out.println("TopicConsumer"+text);
    }
}