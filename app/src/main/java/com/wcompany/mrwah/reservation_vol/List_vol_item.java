package com.wcompany.mrwah.reservation_vol;

import android.widget.Button;

public class List_vol_item {
    private String price;
    private String heure_dep;
    private String heure_arr;
   // Button reserver;


    public List_vol_item(String price, String heure_dep, String heure_arr) {
        this.price = price;
        this.heure_dep = heure_dep;
        this.heure_arr = heure_arr;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHeure_dep() {
        return heure_dep;
    }

    public void setHeure_dep(String heure_dep) {
        this.heure_dep = heure_dep;
    }

    public String getHeure_arr() {
        return heure_arr;
    }

    public void setHeure_arr(String heure_arr) {
        this.heure_arr = heure_arr;
    }
}
