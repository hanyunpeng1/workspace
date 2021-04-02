package com.hanyun.entity;

public class Message {
    private Integer messageId;
    private String userName;
    private String text;
    private String time;

    public Message() {
    }

    public Message(String userName, String text, String time) {
        this.userName = userName;
        this.text = text;
        this.time = time;
    }

    public Message(Integer messageId, String userName, String text, String time) {
        this.messageId = messageId;
        this.userName = userName;
        this.text = text;
        this.time = time;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
