package com.zhaolearn.activemqcoexist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class TopicProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(TopicProvider.class);
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    public void send(String destName, Object message){
        LOGGER.info("发布消息：" + message);
        JmsTemplate jmsTemplate = jmsMessagingTemplate.getJmsTemplate();
        //开启订阅模式
        jmsTemplate.setPubSubDomain(true);
        this.jmsMessagingTemplate.convertAndSend(destName, message);
    }
}
