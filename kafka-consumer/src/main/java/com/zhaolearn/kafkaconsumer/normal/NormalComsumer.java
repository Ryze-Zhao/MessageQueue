package com.zhaolearn.kafkaconsumer.normal;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NormalComsumer {
    private final static Logger LOGGER = LoggerFactory.getLogger(NormalComsumer.class);
    @KafkaListener(topics = {"normal-consumer-group-topic"}, groupId = "normal-consumer-group-id")
    public void listen(ConsumerRecord<?, ?> record) {
        LOGGER.info("NormalComsumer所有信息："+record.toString());
//        LOGGER.info("【消费{}主题, 第{}分区, 数据:{}, 偏移量:{}】", record.topic(), record.partition(), record.value(), record.offset());
    }
}
