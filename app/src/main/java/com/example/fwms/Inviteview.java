package com.example.fwms;

 class Inviteview {
    private String Eventname;
     private String EventType;
     private String Eventlocation;
     private String Eventdate;
     private String Eventcontact;
     private String Eventdesc;



    public Inviteview(String Eventname,String EventType,String Eventlocation,String Eventdate,String Eventcontact,String Eventdesc) {
        this.Eventname = Eventname;
        this.EventType = EventType;
        this.Eventlocation = Eventlocation;
        this.Eventdate = Eventdate;
        this.Eventcontact = Eventcontact;
        this.Eventdesc = Eventdesc;

    }

     public String getEventname() {
        return Eventname;
    }
     public String getEventType() {
         return EventType;
     }
     public String getEventlocation() {
         return Eventlocation;
     }
     public String getEventdate() {
         return Eventdate;
     }
     public String getEventcontact() {
         return Eventcontact;
     }
     public String getEventdesc() {
         return Eventdesc;
     }




}

