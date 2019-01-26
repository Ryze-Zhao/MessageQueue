package com.zhaolearn.activemqdelay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqDelayApplicationTests {
    @Autowired
    private QueueProvider queueProvider;
    @Autowired
    private TopicProvider topicProvider;
    //普通延时
    @Test
    public void testDelay(){
        queueProvider.delaySend(QueueEnum.MESSAGE_QUEUE_ENUM.getQueueName(),new ScheduleMessage(10000L),
                "普通延时发送Queue消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        topicProvider.delaySend(QueueEnum.MESSAGE_TOPIC_ENUM.getQueueName(),new ScheduleMessage(10000L),
                "普通延时发送Topic消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
    //corn定时
    @Test
    public void testDelay1(){
        queueProvider.delaySend(QueueEnum.MESSAGE_QUEUE_ENUM.getQueueName(),new ScheduleMessage("29 * * * *"),
                "corn定时发送Queue消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        topicProvider.delaySend(QueueEnum.MESSAGE_TOPIC_ENUM.getQueueName(),new ScheduleMessage("29 * * * *"),
                "corn定时发送Topic消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    //不延时重复发送，重复发送2次，每次间隔3秒
    @Test
    public void testDelay2(){
        queueProvider.delaySend(QueueEnum.MESSAGE_QUEUE_ENUM.getQueueName(),new ScheduleMessage(3000,2),
                "不延时重复发送Queue消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        topicProvider.delaySend(QueueEnum.MESSAGE_TOPIC_ENUM.getQueueName(),new ScheduleMessage(3000,2),
                "不延时重复发送Topic消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
    //延时重复发送,延时10秒后，重复发送2次，每次间隔3秒
    @Test
    public void testDelay3(){
        queueProvider.delaySend(QueueEnum.MESSAGE_QUEUE_ENUM.getQueueName(),new ScheduleMessage(10000,3000,2),
                "延时重复发送Queue消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        topicProvider.delaySend(QueueEnum.MESSAGE_TOPIC_ENUM.getQueueName(),new ScheduleMessage(10000,3000,2),
                "延时重复发送Topic消息"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}

