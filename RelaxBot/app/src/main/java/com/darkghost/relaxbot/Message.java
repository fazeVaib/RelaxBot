package com.darkghost.relaxbot;

public class Message {
    private String text;
    private MemberData memberData;
    private boolean belongs_to_curr_user;

    public Message(String text, MemberData memberData, boolean belongs_to_curr_user) {
        this.text = text;
        this.memberData = memberData;
        this.belongs_to_curr_user = belongs_to_curr_user;
    }

    public String getText() {
        return text;
    }

    public MemberData getMemberData() {
        return memberData;
    }

    public boolean isBelongs_to_curr_user() {
        return belongs_to_curr_user;
    }
}
