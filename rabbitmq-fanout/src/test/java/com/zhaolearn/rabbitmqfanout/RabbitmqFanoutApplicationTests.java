package com.zhaolearn.rabbitmqfanout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqFanoutApplicationTests {
    @Autowired
    private MessageProvider messageProvider;
    @Test
    public void testStringSend() {
        for (int i = 1; i <=3; i++) {
            messageProvider.send(i+"");
        }
    }

}

