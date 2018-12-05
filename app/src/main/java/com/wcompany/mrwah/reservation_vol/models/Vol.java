package com.wcompany.mrwah.reservation_vol.models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Vol {
    private long num_vol;
    private Date date_Depart;
    private Time heure_Depart;
    private Date date_Arrive;
    private Time heure_Arrive;
    private String avion;
    private int prix;
    private boolean etat;
    private List<Reservation> list_reservation;
    private Aeroport aeroport ;

    public Vol() {
    }

    public Vol(Date date_Depart, Time heure_Depart, Date date_Arrive, Time heure_Arrive, String avion, int prix, boolean etat) {
        this.date_Depart = date_Depart;
        this.heure_Depart = heure_Depart;
        this.date_Arrive = date_Arrive;
        this.heure_Arrive = heure_Arrive;
        this.avion = avion;
        this.prix = prix;
        this.etat = etat;
    }

    public Vol(long num_vol, Date date_Depart, Time heure_Depart, Date date_Arrive, Time heure_Arrive, String avion, int prix, boolean etat) {
        this.num_vol = num_vol;
        this.date_Depart = date_Depart;
        this.heure_Depart = heure_Depart;
        this.date_Arrive = date_Arrive;
        this.heure_Arrive = heure_Arrive;
        this.avion = avion;
        this.prix = prix;
        this.etat = etat;
    }

    public Vol(Date date_Depart, Time heure_Depart, Date date_Arrive, Time heure_Arrive, String avion, boolean etat, List<Reservation> list_reservation, Aeroport aeroport) {
        this.date_Depart = date_Depart;
        this.heure_Depart = heure_Depart;
        this.date_Arrive = date_Arrive;
        this.heure_Arrive = heure_Arrive;
        this.avion = avion;
        this.etat = etat;
        this.list_reservation = list_reservation;
        this.aeroport = aeroport;
    }

    public long getNum_vol() {
        return num_vol;
    }

    public void setNum_vol(long num_vol) {
        this.num_vol = num_vol;
    }

    public Date getDate_Depart() {
        return date_Depart;
    }

    public void setDate_Depart(Date date_Depart) {
        this.date_Depart = date_Depart;
    }

    public Time getHeure_Depart() {
        return heure_Depart;
    }

    public void setHeure_Depart(Time heure_Depart) {
        this.heure_Depart = heure_Depart;
    }

    public Date getDate_Arrive() {
        return date_Arrive;
    }

    public void setDate_Arrive(Date date_Arrive) {
        this.date_Arrive = date_Arrive;
    }

    public Time getHeure_Arrive() {
        return heure_Arrive;
    }

    public void setHeure_Arrive(Time heure_Arrive) {
        this.heure_Arrive = heure_Arrive;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public List<Reservation> getList_reservation() {
        return list_reservation;
    }

    public void setList_reservation(List<Reservation> list_reservation) {
        this.list_reservation = list_reservation;
    }

    public Aeroport getAeroport() {
        return aeroport;
    }

    public void setAeroport(Aeroport aeroport) {
        this.aeroport = aeroport;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Vol{" +
                "num_vol=" + num_vol +
                ", date_Depart=" + date_Depart +
                ", heure_Depart=" + heure_Depart +
                ", date_Arrive=" + date_Arrive +
                ", heure_Arrive=" + heure_Arrive +
                ", avion='" + avion + '\'' +
                ", prix=" + prix +
                ", etat=" + etat +
                ", list_reservation=" + list_reservation +
                ", aeroport=" + aeroport +
                '}';
    }
}
