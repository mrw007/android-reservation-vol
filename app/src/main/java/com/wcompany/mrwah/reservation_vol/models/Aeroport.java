package com.wcompany.mrwah.reservation_vol.models;

import java.util.List;

public class Aeroport {
    private long id_aero;
    private String libelle;
    private String adresse;
    private Ville ville ;

    public Aeroport() {
    }


    public Aeroport(String libelle, String adresse, Ville ville) {
        this.libelle = libelle;
        this.adresse = adresse;
        this.ville = ville;
    }

    public long getId_aero() {
        return id_aero;
    }

    public void setId_aero(long id_aero) {
        this.id_aero = id_aero;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Aeroport{" +
                "id_aero=" + id_aero +
                ", libelle='" + libelle + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville=" + ville +
                '}';
    }
}
