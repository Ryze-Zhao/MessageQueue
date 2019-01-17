package com.zhaolearn.rabbitmqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 这个用于作为Queue的消费者模块
 * @author: HeHaoZhao
 * @date: 2019/1/17 15:42
 */
@SpringBootApplication
public class RabbitmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumerApplication.class, args);
    }

}

