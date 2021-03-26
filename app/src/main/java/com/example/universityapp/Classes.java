package com.example.universityapp;

public class Classes {
    String groupId, date, time, moduleName;


    public Classes() {
    }

    public Classes(String groupId, String date, String time, String moduleName) {
        this.groupId = groupId;
        this.date = date;
        this.time = time;
        this.moduleName = moduleName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
