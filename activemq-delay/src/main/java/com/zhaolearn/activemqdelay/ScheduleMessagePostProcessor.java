package com.zhaolearn.activemqdelay;

import org.apache.activemq.ScheduledMessage;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.util.StringUtils;

import javax.jms.JMSException;
import javax.jms.Message;


/**
 * 使用long代表延时多久；
 * 使用corn代表定时，格式为 分 时 日 月 年，不填就用*，如果在每天15：50分发送；50 15 * * *
 *
 * @author: HeHaoZhao
 * @date: 2019/1/25 17:43
 */
public class ScheduleMessagePostProcessor implements MessagePostProcessor {
    private long delay = 0L;
    private String corn = null;
    public ScheduleMessagePostProcessor(long delay) {
        this.delay = delay;
    }
    public ScheduleMessagePostProcessor(String cron) {
        this.corn = cron;
    }

    @Override
    public Message postProcessMessage(Message message) throws JMSException {
        if (delay > 0) {
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
        }
        if (!StringUtils.isEmpty(corn)) {
            message.setStringProperty(ScheduledMessage.AMQ_SCHEDULED_CRON, corn);
        }
        return message;
    }
}
