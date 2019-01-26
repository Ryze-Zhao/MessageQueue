package com.zhaolearn.activemqdelay;

import org.apache.activemq.ScheduledMessage;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.util.StringUtils;

import javax.jms.JMSException;
import javax.jms.Message;


/**
 * 使用long代表延时多久；
 * 使用corn代表定时，格式为 分 时 日 月 年，不填就用*，如果在每天15：50分发送；50 15 * * *
 * @author: HeHaoZhao
 * @date: 2019/1/25 17:43
 */
public class ScheduleMessage implements MessagePostProcessor {
    private long delay = 0L;//延迟多久
    //格式为 分 时 日 月 年，不填就用*，如果在每天15：50分发送；50 15 * * *
    private String corn = null;
    private long period = 0L;//重复投递的时间间隔
    private int repeat = 0;//重复投递次数
    public ScheduleMessage(long delay) {
        this.delay = delay;
    }
    public ScheduleMessage(String cron) {
        this.corn = cron;
    }
    public ScheduleMessage(long period, int repeat) {
        this.period = period;
        this.repeat = repeat;
    }
    public ScheduleMessage(long delay, long period, int repeat) {
        this.delay = delay;
        this.period = period;
        this.repeat = repeat;
    }
    @Override
    public Message postProcessMessage(Message message) throws JMSException {
        if (delay > 0) {
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
        }
        if (!StringUtils.isEmpty(corn)) {
            message.setStringProperty(ScheduledMessage.AMQ_SCHEDULED_CRON, corn);
        }
        //repeat-1原因是，传入N，实际发送为N+1次
        if(period>0&&repeat>0&&delay==0){
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
            message.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat-1);
        }else if(period>0&&repeat>0&&delay!=0){
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
            message.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat-1);
        }
        return message;
    }
}
