package com.zaaach.citypicker.model;

/**
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * <p>
 * Created by zjm on 2017/4/4.
 */

public class MsgEventBus {
    private City city;

    public MsgEventBus(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
