package com.example.fwms;

public class Contacts {

    private long id;
    private String event_type;
    private String event_name;
    private String event_dattime;
    private String event_contact;
    private String event_describtiont;

    public Contacts(int id, String event_type, String event_name, String event_dattime, String event_contact, String event_describtiont) {

        this.id = id;
        this.event_type = event_type;
        this.event_name = event_name;
        this.event_dattime = event_dattime;
        this.event_contact = event_contact;
        this.event_describtiont = event_describtiont;

    }

    public long getId() {
        return id;
    }

    public String getEvent_type() {
        return event_type;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_dattime() {
        return event_dattime;
    }

    public String getEvent_contact() {
        return event_contact;
    }

    public String getEvent_describtiont() {
        return event_describtiont;
    }
}





