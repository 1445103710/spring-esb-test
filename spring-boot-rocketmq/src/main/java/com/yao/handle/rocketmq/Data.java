package com.yao.handle.rocketmq;

import java.io.Serializable;

/**
 * @className Data
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/03/12 17:18
 */
public class Data implements Serializable {

    /**
     * aa : 123
     * BUSINESS_ID : 4
     * JOB_TASK_ID : 1_测试mq服务@-@0@-@READY@-@192.168.209.103@-@95152
     * SHARDING_TOTAL_COUNT : 1
     * SHARDING_ITEM : 0
     * SHARDING_PARAMETER : A
     * JOB_NAME : 1_测试mq服务
     */

    private String aa;
    private int BUSINESS_ID;
    private String JOB_TASK_ID;
    private int SHARDING_TOTAL_COUNT;
    private int SHARDING_ITEM;
    private String SHARDING_PARAMETER;
    private String JOB_NAME;

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public int getBUSINESS_ID() {
        return BUSINESS_ID;
    }

    public void setBUSINESS_ID(int BUSINESS_ID) {
        this.BUSINESS_ID = BUSINESS_ID;
    }

    public String getJOB_TASK_ID() {
        return JOB_TASK_ID;
    }

    public void setJOB_TASK_ID(String JOB_TASK_ID) {
        this.JOB_TASK_ID = JOB_TASK_ID;
    }

    public int getSHARDING_TOTAL_COUNT() {
        return SHARDING_TOTAL_COUNT;
    }

    public void setSHARDING_TOTAL_COUNT(int SHARDING_TOTAL_COUNT) {
        this.SHARDING_TOTAL_COUNT = SHARDING_TOTAL_COUNT;
    }

    public int getSHARDING_ITEM() {
        return SHARDING_ITEM;
    }

    public void setSHARDING_ITEM(int SHARDING_ITEM) {
        this.SHARDING_ITEM = SHARDING_ITEM;
    }

    public String getSHARDING_PARAMETER() {
        return SHARDING_PARAMETER;
    }

    public void setSHARDING_PARAMETER(String SHARDING_PARAMETER) {
        this.SHARDING_PARAMETER = SHARDING_PARAMETER;
    }

    public String getJOB_NAME() {
        return JOB_NAME;
    }

    public void setJOB_NAME(String JOB_NAME) {
        this.JOB_NAME = JOB_NAME;
    }
}
