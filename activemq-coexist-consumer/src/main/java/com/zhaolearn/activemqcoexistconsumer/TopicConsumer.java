package com.zhaolearn.activemqcoexistconsumer;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;


@Component
public class TopicConsumer {
    @JmsListener(destination = "message.topic.enum.name", containerFactory = "jmsListenerContainerTopic")
    public void subscriber(Object obj) {
        try {
            //接受对象消息
            if (obj instanceof ActiveMQObjectMessage) {
                Object sourObj = ((ActiveMQObjectMessage) obj).getObject();
                System.out.println("TopicConsumer收到订阅消息：" + sourObj);
            }else if(obj instanceof ActiveMQTextMessage){
                String sourObj = ((ActiveMQTextMessage) obj).getText();
                System.out.println("TopicConsumer收到订阅消息：" + sourObj);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}