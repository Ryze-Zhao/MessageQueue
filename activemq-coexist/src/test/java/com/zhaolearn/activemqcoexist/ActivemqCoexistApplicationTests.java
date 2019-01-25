package com.zhaolearn.activemqcoexist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqCoexistApplicationTests {
    @Autowired
    private QueueProvider queueProvider;
    @Autowired
    private TopicProvider topicProvider;

    @Test
    public void testCoexist() {
        queueProvider.send(QueueEnum.MESSAGE_QUEUE_ENUM.getQueueName(),
                    "即时发送Queue消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        topicProvider.send(QueueEnum.MESSAGE_TOPIC_ENUM.getQueueName(),
                "即时发送Topic消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }


}

