package com.ahmed.whatsapp.model;

public class Chat {
    private int userImg;
    private String name,lastMsg,msgDate,numOfMsgs,stateOfMessages;

    public Chat(int userImg, String name, String lastMsg, String msgDate, String numOfMsgs,String stateOfMessages) {
        this.userImg = userImg;
        this.name = name;
        this.lastMsg = lastMsg;
        this.msgDate = msgDate;
        this.numOfMsgs = numOfMsgs;
        this.stateOfMessages = stateOfMessages;
    }

    public int getUserImg() {
        return userImg;
    }

    public void setUserImg(int userImg) {
        this.userImg = userImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public String getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(String msgDate) {
        this.msgDate = msgDate;
    }

    public String getNumOfMsgs() {
        return numOfMsgs;
    }

    public void setNumOfMsgs(String numOfMsgs) {
        this.numOfMsgs = numOfMsgs;
    }

    public String getStateOfMessages() {
        return stateOfMessages;
    }

    public void setStateOfMessages(String stateOfMessages) {
        this.stateOfMessages = stateOfMessages;
    }
}
