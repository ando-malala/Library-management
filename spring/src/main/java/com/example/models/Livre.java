package com.example.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLivre;

    @Column(length = 200)
    private String titre;

    @Column(name = "livre_edition", length = 100)
    private String livreEdition;

    @Column(length = 100, nullable = false)
    private String auteur;

    @Column(name = "date_sortie")
    private LocalDate dateSortie;

    @ManyToOne
    @JoinColumn(name = "id_type_livre")
    private TypeLivre typeLivre;

    @Column(name = "date_ajout")
    private LocalDate dateAjout;

    @Column(name = "nombre_exemplaires")
    private Integer nombreExemplaires;

    public Integer getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLivreEdition() {
        return livreEdition;
    }

    public void setLivreEdition(String livreEdition) {
        this.livreEdition = livreEdition;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public TypeLivre getTypeLivre() {
        return typeLivre;
    }

    public void setTypeLivre(TypeLivre typeLivre) {
        this.typeLivre = typeLivre;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Integer getNombreExemplaires() {
        return nombreExemplaires;
    }

    public void setNombreExemplaires(Integer nombreExemplaires) {
        this.nombreExemplaires = nombreExemplaires;
    }
}