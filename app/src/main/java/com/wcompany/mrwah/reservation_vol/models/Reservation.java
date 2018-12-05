package com.wcompany.mrwah.reservation_vol.models;

import java.sql.Date;
import java.util.List;

public class Reservation {
    private long id_res;
    private Date date;
    private String numero;
    Vol vol;
    Client client;
    List<Passager> passagers;

    public Reservation() {
    }

    public Reservation(long id_res, Date date, String numero, Vol vol, Client client, List<Passager> passagers) {
        this.id_res = id_res;
        this.date = date;
        this.numero = numero;
        this.vol = vol;
        this.client = client;
        this.passagers = passagers;
    }

    public Reservation(Date date, Vol vol, Client client, List<Passager> passagers) {
        this.date = date;
        this.vol = vol;
        this.client = client;
        this.passagers = passagers;
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

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Passager> getPassagers() {
        return passagers;
    }

    public void setPassagers(List<Passager> passagers) {
        this.passagers = passagers;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id_res=" + id_res +
                ", date=" + date +
                ", numero='" + numero + '\'' +
                ", vol=" + vol +
                ", client=" + client +
                ", passagers=" + passagers +
                '}';
    }
}
