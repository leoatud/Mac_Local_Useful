package com.qq.common;

import java.io.Serializable;

/**
 * set rules for message
 * mesType 1 --> login successful
 * mesType 2 --> login fail
 * mesType 3 --> normal message package
 */


public class Message implements Serializable {

    private String mesType;
    private String sender;
    private String receiver;
    private String sendTime;
    private String content;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}
