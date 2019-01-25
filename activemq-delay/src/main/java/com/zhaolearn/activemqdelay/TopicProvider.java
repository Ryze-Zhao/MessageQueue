package com.zhaolearn.activemqdelay;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class TopicProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(TopicProvider.class);
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    public void delaySend(String destName, int time, Object message){
        JmsTemplate jmsTemplate = jmsMessagingTemplate.getJmsTemplate();
        //开启订阅模式
        jmsTemplate.setPubSubDomain(true);
        Destination destination = new ActiveMQTopic(destName);
        jmsTemplate.convertAndSend(destination,message,new ScheduleMessagePostProcessor(time));
        LOGGER.info("发送"+message);
    }
}
