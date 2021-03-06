package com.wcompany.mrwah.reservation_vol.models;

import java.util.List;

public class Passager {
    private long idPas;
    private String cinPas;
    private String nomPas;
    private String prenomPas;
    private List<Reservation> reservations;

    public Passager() {
    }

    public Passager(String cinPas, String nomPas, String prenomPas) {
        this.cinPas = cinPas;
        this.nomPas = nomPas;
        this.prenomPas = prenomPas;
    }

    public Passager(String cinPas, String nomPas, String prenomPas, List<Reservation> reservations) {
        this.cinPas = cinPas;
        this.nomPas = nomPas;
        this.prenomPas = prenomPas;
        this.reservations = reservations;
    }

    public long getIdPas() {
        return idPas;
    }

    public void setIdPas(long idPas) {
        this.idPas = idPas;
    }

    public String getCinPas() {
        return cinPas;
    }

    public void setCinPas(String cinPas) {
        this.cinPas = cinPas;
    }

    public String getNomPas() {
        return nomPas;
    }

    public void setNomPas(String nomPas) {
        this.nomPas = nomPas;
    }

    public String getPrenomPas() {
        return prenomPas;
    }

    public void setPrenomPas(String prenomPas) {
        this.prenomPas = prenomPas;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Passager{" +
                "idPas=" + idPas +
                ", cinPas='" + cinPas + '\'' +
                ", nomPas='" + nomPas + '\'' +
                ", prenomPas='" + prenomPas + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
