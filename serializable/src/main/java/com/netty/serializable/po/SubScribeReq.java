package com.netty.serializable.po;

import java.io.Serializable;

/**
 * 请求包装类
 * Created by xiaoyun on 2016/3/24.
 */
public class SubScribeReq implements Serializable {

    /**
      * 默认的序列号ID
      */
    private static final long serialVersionUID = 164767044487826605L;
    /** 订购编号 */
    private int subReqID;
    /** 用户名 */
    private String userName;
    /** 产品名称 */
    private String productName;
    /** 电话号码 */
    private String phoneNumber;
    /** 地址 */
    private String address;

    public int getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SubScribeReq{" +
                "subReqID=" + subReqID +
                ", userName='" + userName + '\'' +
                ", productName='" + productName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}