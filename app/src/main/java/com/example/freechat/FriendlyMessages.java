package com.example.freechat;

public class FriendlyMessages {


    private String text;
    private String name;
    private String photoUrl;
    private String senderid;

    public FriendlyMessages() {
    }

    public FriendlyMessages(String senderid, String text, String name, String photoUrl) {
        this.senderid = senderid;
        this.text = text;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
