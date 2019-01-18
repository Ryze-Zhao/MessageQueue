package com.zhaolearn.rabbitmqdirect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqDirectApplicationTests {

    @Autowired
    private MessageProvider messageProvider;
    @Test
    public void testStringSend() {
        for (int i = 1; i <=2; i++) {
            messageProvider.send(QueueEnum.MESSAGE_EXCHANGE_DIRECT.getExchange(),QueueEnum.MESSAGE_QUEUE_DIRECTA1.getRouteKey(),i+"A1");
            messageProvider.send(QueueEnum.MESSAGE_EXCHANGE_DIRECT.getExchange(),QueueEnum.MESSAGE_QUEUE_DIRECTB1.getRouteKey(),i+"B1");
            messageProvider.send(QueueEnum.MESSAGE_EXCHANGE_DIRECT.getExchange(),QueueEnum.MESSAGE_QUEUE_DIRECTB2.getRouteKey(),i+"B2");
            messageProvider.send(QueueEnum.MESSAGE_EXCHANGE_DIRECT.getExchange(),"ErrorKey",i+"NoQueue");
        }
    }

}

