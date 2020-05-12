package com.example.musicpro.Model;

public class Venue {
    String name;
    String address;
    String time;

    public Venue(String name,String address){//,String time){
        this.name=name;
        this.address=address;
        //this.time=time;
    }

    public Venue(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
