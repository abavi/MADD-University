package com.example.universityapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivitiesModel {
    String activitiesTitle, activitiesDesc, activitiesDate;
    Date calendarDate;

    public ActivitiesModel() {
    }

    public ActivitiesModel(String activitiesTitle, String activitiesDesc, String activitiesDate) {
        this.activitiesTitle = activitiesTitle;
        this.activitiesDesc = activitiesDesc;
        this.activitiesDate = activitiesDate;
    }

    public String getActivitiesTitle() {
        return activitiesTitle;
    }

    public void setActivitiesTitle(String activitiesTitle) {
        this.activitiesTitle = activitiesTitle;
    }

    public String getActivitiesDesc() {
        return activitiesDesc;
    }

    public void setActivitiesDesc(String activitiesDesc) {
        this.activitiesDesc = activitiesDesc;
    }

    public String getActivitiesDate() {
        return activitiesDate;
    }

    public void setActivitiesDate(String activitiesDate) {
        this.activitiesDate = activitiesDate;
    }

    public Date getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(Date calendarDate) {
        this.calendarDate = calendarDate;
    }

    public Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "ActivitiesModel{" +
                "activitiesTitle='" + activitiesTitle + '\'' +
                ", activitiesDesc='" + activitiesDesc + '\'' +
                ", activitiesDate='" + activitiesDate + '\'' +
                ", calendarDate=" + calendarDate +
                '}';
    }
}
