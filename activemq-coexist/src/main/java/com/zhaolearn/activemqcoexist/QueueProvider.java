package com.zhaolearn.activemqcoexist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class QueueProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(QueueProvider.class);
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    public void send(String destName, Object message){
        LOGGER.info("发布消息：" + message);
        this.jmsMessagingTemplate.convertAndSend(destName, message);
    }
}
