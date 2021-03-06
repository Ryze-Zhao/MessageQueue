package com.zhaolearn.kafkaconsumer.normal;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 测试单收单发单分区，请关闭这个类
 * @author: HeHaoZhao
 * @date: 2019/1/31 10:15
 */
@Component
public class NormalConsumer2 {
    private final static Logger LOGGER = LoggerFactory.getLogger(NormalConsumer2.class);
    @KafkaListener(topics = {"normal_consumer_group_topic"}, groupId = "normal_consumer_group_id")
    public void listen(ConsumerRecord<?, ?> record) {
        LOGGER.info("NormalConsumer2所有信息："+record.toString());
//        LOGGER.info("【消费{}主题, 第{}分区, 数据:{}, 偏移量:{}】", record.topic(), record.partition(), record.value(), record.offset());
    }
}
