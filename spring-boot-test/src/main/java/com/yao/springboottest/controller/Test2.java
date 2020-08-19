package com.yao.springboottest.controller;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/10 14:43
 */

public class Test2 implements Serializable {

    @JSONField(name = "BUSINESS_ID")
    private long businessID;
    @JSONField(name = "JOB_TASK_ID")
    private String jobTaskID;
    @JSONField(name = "SHARDING_TOTAL_COUNT")
    private long shardingTotalCount;
    @JSONField(name = "SHARDING_ITEM")
    private long shardingItem;
    @JSONField(name = "SHARDING_PARAMETER")
    private String shardingParameter;
    @JSONField(name = "JOB_NAME")
    private String jobName;

    public long getBusinessID() {
        return businessID;
    }

    public void setBusinessID(long value) {
        this.businessID = value;
    }

    public String getJobTaskID() {
        return jobTaskID;
    }

    public void setJobTaskID(String value) {
        this.jobTaskID = value;
    }

    public long getShardingTotalCount() {
        return shardingTotalCount;
    }

    public void setShardingTotalCount(long value) {
        this.shardingTotalCount = value;
    }

    public long getShardingItem() {
        return shardingItem;
    }

    public void setShardingItem(long value) {
        this.shardingItem = value;
    }

    public String getShardingParameter() {
        return shardingParameter;
    }

    public void setShardingParameter(String value) {
        this.shardingParameter = value;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String value) {
        this.jobName = value;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "businessID=" + businessID +
                ", jobTaskID='" + jobTaskID + '\'' +
                ", shardingTotalCount=" + shardingTotalCount +
                ", shardingItem=" + shardingItem +
                ", shardingParameter='" + shardingParameter + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}

