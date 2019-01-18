package com.zhaolearn.rabbitmqtopic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTopicApplicationTests {
    @Autowired
    private MessageProvider messageProvider;
    @Test
    public void testStringSend() {
            messageProvider.send(QueueEnum.MESSAGE_EXCHANGE_TOPIC.getExchange(),"message.rabbit.queue.topic.msg","1");
            messageProvider.send(QueueEnum.MESSAGE_EXCHANGE_TOPIC.getExchange(),"message.rabbit.queue.topic.good","1");
            messageProvider.send(QueueEnum.MESSAGE_EXCHANGE_TOPIC.getExchange(),"message.rabbit.queue.topic.asdsam.sdsadsa.asdas","1");
    }
}

