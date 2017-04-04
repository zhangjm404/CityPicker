package com.zaaach.citypicker.model;

/**
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * <p>
 * Created by zjm on 2017/4/4.
 */

public class MsgEventBus {
    private String city;

    public MsgEventBus(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
