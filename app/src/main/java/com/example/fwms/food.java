package com.example.fwms;

class Food {
    private String guestname;
    private String Fooddetails;

    public Food(String guestname, String fooddetails) {
        this.guestname = guestname;
        Fooddetails = fooddetails;
    }


    public String getGuestname() {
        return guestname;
    }

    public String getFooddetails() {
        return Fooddetails;
    }
}
