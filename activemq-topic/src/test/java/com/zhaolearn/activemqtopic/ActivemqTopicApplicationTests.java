package com.zhaolearn.activemqtopic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqTopicApplicationTests {
    @Autowired
    private MessageProvider messageProvider;
    @Test
    public void test() {
        for(int i=0;i<5;i++){
            String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            messageProvider.send(QueueEnum.MESSAGE_TOPIC_ENUM.getExchange(), " 测试消费,写入时间：" + dateString);
        }
    }
}

