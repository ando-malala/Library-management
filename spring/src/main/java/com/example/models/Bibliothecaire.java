package com.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bibliothecaire")
public class Bibliothecaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBibliothecaire;

    @Column(length = 55)
    private String nom;

    @Column(length = 55)
    private String prenom;

    @Column(length = 55)
    private String email;

    @Column(length = 55)
    private String motDePasse;

    public Integer getIdBibliothecaire() {
        return idBibliothecaire;
    }

    public void setIdBibliothecaire(Integer idBibliothecaire) {
        this.idBibliothecaire = idBibliothecaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}