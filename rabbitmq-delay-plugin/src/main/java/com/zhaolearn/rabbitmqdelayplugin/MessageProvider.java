package com.zhaolearn.rabbitmqdelayplugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MessageProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageProvider.class);
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String exchange, String routerKey, Object messageContent,final Integer delayTimes) {
        if (!StringUtils.isEmpty(exchange)) {
            LOGGER.info("测试插件延迟：{}毫秒写入消息队列：{}，消息内容：{}", delayTimes, routerKey, messageContent);
            // 执行发送消息到指定队列
            rabbitTemplate.convertAndSend(exchange, routerKey, messageContent, message -> {
                // 设置延迟毫秒值
                message.getMessageProperties().setHeader("x-delay",delayTimes);
                return message;
            });
        } else {
            LOGGER.error("未找到队列消息：{}，所属的交换机", exchange);
        }
    }
}
