package com.wcompany.mrwah.reservation_vol.models;

import java.util.List;

public class Client {
    private long idClt;
    private String loginClt;
    private String passwordClt;
    private String cinClt;
    private String nomClt;
    private String prenomClt;
    private int ageClt;
    private String adresseClt;
    private String numTel;
    private String mailClt;
    private List<Reservation> reservations;

    public Client() {
    }

    public Client(String loginClt, String passwordClt) {
        this.loginClt = loginClt;
        this.passwordClt = passwordClt;
    }

    public Client(String loginClt, String passwordClt, String cinClt, String nomClt, String prenomClt, int ageClt, String adresseClt, String numTel, String mailClt) {
        this.loginClt = loginClt;
        this.passwordClt = passwordClt;
        this.cinClt = cinClt;
        this.nomClt = nomClt;
        this.prenomClt = prenomClt;
        this.ageClt = ageClt;
        this.adresseClt = adresseClt;
        this.numTel = numTel;
        this.mailClt = mailClt;
    }

    public Client(String loginClt, String passwordClt, String cinClt, String nomClt, String prenomClt, int ageClt, String adresseClt, String numTel, String mailClt, List<Reservation> reservations) {
        this.loginClt = loginClt;
        this.passwordClt = passwordClt;
        this.cinClt = cinClt;
        this.nomClt = nomClt;
        this.prenomClt = prenomClt;
        this.ageClt = ageClt;
        this.adresseClt = adresseClt;
        this.numTel = numTel;
        this.mailClt = mailClt;
        this.reservations = reservations;
    }

    public long getIdClt() {
        return idClt;
    }

    public void setIdClt(long idClt) {
        this.idClt = idClt;
    }

    public String getloginClt() {
        return loginClt;
    }

    public void setloginClt(String loginClt) {
        this.loginClt = loginClt;
    }

    public String getpasswordClt() {
        return passwordClt;
    }

    public void setpasswordClt(String passwordClt) {
        this.passwordClt = passwordClt;
    }

    public String getCin_clt() {
        return cinClt;
    }

    public void setCin_clt(String cinClt) {
        this.cinClt = cinClt;
    }

    public String getNom_clt() {
        return nomClt;
    }

    public void setNom_clt(String nomClt) {
        this.nomClt = nomClt;
    }

    public String getPrenom_clt() {
        return prenomClt;
    }

    public void setPrenom_clt(String prenomClt) {
        this.prenomClt = prenomClt;
    }

    public int getAge_clt() {
        return ageClt;
    }

    public void setAge_clt(int ageClt) {
        this.ageClt = ageClt;
    }

    public String getAdresse_clt() {
        return adresseClt;
    }

    public void setAdresse_clt(String adresseClt) {
        this.adresseClt = adresseClt;
    }

    public String getNum_tel_clt() {
        return numTel;
    }

    public void setNum_tel_clt(String numTel) {
        this.numTel = numTel;
    }

    public String getMail_clt() {
        return mailClt;
    }

    public void setMail_clt(String mailClt) {
        this.mailClt = mailClt;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClt=" + idClt +
                ", loginClt='" + loginClt + '\'' +
                ", passwordClt='" + passwordClt + '\'' +
                ", cinClt='" + cinClt + '\'' +
                ", nomClt='" + nomClt + '\'' +
                ", prenomClt='" + prenomClt + '\'' +
                ", ageClt=" + ageClt +
                ", adresseClt='" + adresseClt + '\'' +
                ", numTel='" + numTel + '\'' +
                ", mailClt='" + mailClt + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
