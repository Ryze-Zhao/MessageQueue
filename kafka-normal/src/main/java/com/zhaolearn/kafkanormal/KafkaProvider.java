package com.zhaolearn.kafkanormal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(KafkaProvider.class);
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendNormal(String name,String key, String message) {
        LOGGER.info("KafkaProvider发送的消息={}", message);
        kafkaTemplate.send(name,key,message);
    }


}