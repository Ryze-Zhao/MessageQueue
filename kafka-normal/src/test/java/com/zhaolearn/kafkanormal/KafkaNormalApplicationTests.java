package com.zhaolearn.kafkanormal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaNormalApplicationTests {

    @Autowired
    private KafkaProvider kafkaProvider;
    @Test
    public void contextLoads() {
        for (int i = 0; i < 3; i++) {
            String message="KafkaNormal消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            kafkaProvider.sendNormal(KafkaEnum.NORMAL.getTopicName(),KafkaEnum.NORMAL.getKey()+i,message);
        }
    }

}

