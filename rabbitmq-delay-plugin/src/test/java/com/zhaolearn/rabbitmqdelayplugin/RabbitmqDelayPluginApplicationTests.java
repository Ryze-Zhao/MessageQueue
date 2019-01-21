package com.zhaolearn.rabbitmqdelayplugin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqDelayPluginApplicationTests {
    @Autowired
    private MessageProvider messageProvider;
    @Test
    public void contextLoads() {
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        // 测试延迟10秒
        messageProvider.send(
                QueueEnum.MESSAGE_EXCHANGE_DELAY_PLUGIN.getExchange(),
                QueueEnum.MESSAGE_EXCHANGE_DELAY_PLUGIN.getRouteKey(),
                "测试延迟消费,写入时间：" + dateString,
                10000);
    }
}

