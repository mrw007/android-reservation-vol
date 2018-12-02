package com.wcompany.mrwah.reservation_vol;

import java.sql.Date;

public class List_reservation_item {
    private long id_res;
    private Date date;
    private String numero;

    public List_reservation_item(long id_res, Date date, String numero) {
        this.id_res = id_res;
        this.date = date;
        this.numero = numero;
    }

    public long getId_res() {
        return id_res;
    }

    public void setId_res(long id_res) {
        this.id_res = id_res;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
