package com.example.models;

import jakarta.persistence.*;;

@Entity
@Table(name = "adherant")
public class Adherant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdherant;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 20)
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "id_type_adherant")
    private TypeAdherant typeAdherant;

    public Integer getIdAdherant() {
        return idAdherant;
    }

    public void setIdAdherant(Integer idAdherant) {
        this.idAdherant = idAdherant;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public TypeAdherant getTypeAdherant() {
        return typeAdherant;
    }

    public void setTypeAdherant(TypeAdherant typeAdherant) {
        this.typeAdherant = typeAdherant;
    }
}