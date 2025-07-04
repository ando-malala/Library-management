package com.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "historique_nb_exemplaire")
public class HistoriqueNbExemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistoriqueExemplaire;

    @ManyToOne
    @JoinColumn(name = "id_livre")
    private Livre livre;

    @Column(name = "exemplaire_disponible")
    private Integer exemplaireDisponible;

    @Column(name = "nombre_disponible")
    private Integer nombreDisponible;

    public Integer getIdHistoriqueExemplaire() {
        return idHistoriqueExemplaire;
    }

    public void setIdHistoriqueExemplaire(Integer idHistoriqueExemplaire) {
        this.idHistoriqueExemplaire = idHistoriqueExemplaire;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Integer getExemplaireDisponible() {
        return exemplaireDisponible;
    }

    public void setExemplaireDisponible(Integer exemplaireDisponible) {
        this.exemplaireDisponible = exemplaireDisponible;
    }

    public Integer getNombreDisponible() {
        return nombreDisponible;
    }

    public void setNombreDisponible(Integer nombreDisponible) {
        this.nombreDisponible = nombreDisponible;
    }
}