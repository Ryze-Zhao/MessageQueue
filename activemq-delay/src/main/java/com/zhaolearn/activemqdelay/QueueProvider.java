package com.zhaolearn.activemqdelay;

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
    public void delaySend(String destName, int time, Object message) {
        jmsMessagingTemplate.getJmsTemplate().convertAndSend(destName, message, new ScheduleMessagePostProcessor(time));
        LOGGER.info("发送" + message);
    }
}
