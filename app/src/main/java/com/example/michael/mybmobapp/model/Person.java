package com.example.michael.mybmobapp.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by Michael on 16/2/25.
 */
public class Person extends BmobObject {
    private String name;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
