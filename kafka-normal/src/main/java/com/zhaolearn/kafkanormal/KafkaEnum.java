package com.zhaolearn.kafkanormal;

/**
 *
 * @author: HeHaoZhao
 * @date: 2019/1/17 17:30
 */
public enum KafkaEnum {
    NORMAL("normal_consumer_group_topic","normal_consumer_group_key","normal_consumer_group_id");
    /**
     * Topic名称
     */
    private String topicName;
    /**
     * key
     */
    private String key;
    /**
     * groupId
     */
    private String groupId;

    KafkaEnum(String topicName, String key, String groupId) {
        this.topicName = topicName;
        this.key = key;
        this.groupId = groupId;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getKey() {
        return key;
    }

    public String getGroupId() {
        return groupId;
    }
}
