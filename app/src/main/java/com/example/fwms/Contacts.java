package com.example.fwms;

public class Contacts {
    private long id;
    private String Event_Type;
    private String Event_name;
    private String Event_dattime;
    private String Event_noofguests;
    private String Event_contact;
    private String Event_describtiont;

    public  Contacts(int rowid, String rownametype, String rowname, String rowtime, String rowcontact, String rowiddess) {
    }

    public long getId() {
        return id;
    }

    public String getEvent_Type() {
        return Event_Type;
    }

    public String getEvent_name() {
        return Event_name;
    }

    public String getEvent_dattime() {
        return Event_dattime;
    }

    public String getEvent_noofguests() {
        return Event_noofguests;
    }

    public String getEvent_contact() {
        return Event_contact;
    }

    public String getEvent_describtiont() {
        return Event_describtiont;
    }

    public Contacts(long id, String event_Type, String event_name, String event_dattime, String event_noofguests, String event_contact, String event_describtiont) {
        this.id = id;
        Event_Type = event_Type;
        Event_name = event_name;
        Event_dattime = event_dattime;
        Event_noofguests = event_noofguests;
        Event_contact = event_contact;
        Event_describtiont = event_describtiont;


    }
}
