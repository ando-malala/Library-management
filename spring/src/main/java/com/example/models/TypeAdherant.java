package com.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "type_adherant")
public class TypeAdherant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypeAdherant;

    @Column(length = 100)
    private String libelle;

    public Integer getIdTypeAdherant() {
        return idTypeAdherant;
    }

    public void setIdTypeAdherant(Integer idTypeAdherant) {
        this.idTypeAdherant = idTypeAdherant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}