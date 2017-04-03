package com.example.hetal13.recycler_card_demo;

/**
 * Created by Hetal13 on 01-11-2016.
 */

public class Contact  {
private int img_id;
    private String email,mobile,name;


    public Contact(int img_id, String name, String email, String mobile)
    {
        this.setImg_id(img_id);
        this.setName(name);
        this.setEmail(email);
        this.setMobile(mobile);
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
