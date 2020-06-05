package com.transportation.lm14.transport.model;

/**
 * Created by Maung Oo Thann on 10/17/2017.
 */

public class Vehicle {

    String name, start, end, ph_no, address, departure, time, category;
    String fprice,sprice;
    String favorite,id;

    public Vehicle(String name, String start, String end, String ph_no, String address, String departure, String time, String category, String fprice, String sprice, String id) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.ph_no = ph_no;
        this.address = address;
        this.departure = departure;
        this.time = time;
        this.category = category;
        this.fprice = fprice;
        this.sprice = sprice;
        this.id = id;
    }

    public Vehicle() {
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public Vehicle(String name, String start, String end, String ph_no, String address, String departure, String time, String category, String fprice, String sprice, String favorite, String id) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.ph_no = ph_no;
        this.address = address;
        this.departure = departure;
        this.time = time;
        this.category = category;
        this.fprice = fprice;
        this.sprice = sprice;
        this.favorite = favorite;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFprice() {
        return fprice;
    }

    public void setFprice(String fprice) {
        this.fprice = fprice;
    }

    public String getSprice() {
        return sprice;
    }

    public void setSprice(String sprice) {
        this.sprice = sprice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
