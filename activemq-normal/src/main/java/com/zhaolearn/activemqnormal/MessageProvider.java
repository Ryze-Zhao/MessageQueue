package com.zhaolearn.activemqnormal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageProvider.class);
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    public void send(String destName, Object message){
        System.out.println("发布消息：" + message);
        jmsMessagingTemplate.convertAndSend(destName, message);
    }
}
