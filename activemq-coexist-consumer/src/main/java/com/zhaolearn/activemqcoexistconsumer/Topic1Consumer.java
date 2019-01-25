package com.zhaolearn.activemqcoexistconsumer;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;


@Component
public class Topic1Consumer {
    private final static Logger LOGGER = LoggerFactory.getLogger(Topic1Consumer.class);
    @JmsListener(destination = "message.topic.enum.name", containerFactory = "jmsListenerContainerTopic")
    public void subscriber(Object obj) {
        try {
            //接受对象消息
            if (obj instanceof ActiveMQObjectMessage) {
                Object sourObj = ((ActiveMQObjectMessage) obj).getObject();
                LOGGER.info("Topic1Consumer收到订阅消息：" + sourObj);
            }else if(obj instanceof ActiveMQTextMessage){
                String sourObj = ((ActiveMQTextMessage) obj).getText();
                LOGGER.info("Topic1Consumer收到订阅消息：" + sourObj);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}