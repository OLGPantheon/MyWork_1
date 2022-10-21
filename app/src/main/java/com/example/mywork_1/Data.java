package com.example.mywork_1;
public class Data {
    private String name;
    private String msg;
    private String date;

    public Data(String name, String msg, String date) {
        this.name = name;
        this.msg = msg;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
