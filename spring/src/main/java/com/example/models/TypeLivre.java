package com.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "type_livre")
public class TypeLivre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypeLivre;

    @Column(length = 100)
    private String libelle;

    public Integer getIdTypeLivre() {
        return idTypeLivre;
    }

    public void setIdTypeLivre(Integer idTypeLivre) {
        this.idTypeLivre = idTypeLivre;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}