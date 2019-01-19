package com.zhaolearn.rabbitmqdlxttl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqDlxTtlApplicationTests {

    @Autowired
    private MessageProvider messageProvider;
    @Test
    public void testLazy() {
        // 测试延迟10000毫秒
        messageProvider.send("测试延迟消费,写入时间：" + new Date(),
                QueueEnum.MESSAGE_TTL_QUEUE.getExchange(),
                QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey(),
                10000);
    }
}

