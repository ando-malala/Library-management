package com.example.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historique_pret")

public class HistoriquePret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistoriquePret;

    @ManyToOne
    @JoinColumn(name = "id_pret")
    private Pret pret;

    @Column(name = "date_historique_pret")
    private LocalDateTime dateHistoriquePret;

    private Integer statut;

    public Integer getIdHistoriquePret() {
        return idHistoriquePret;
    }

    public void setIdHistoriquePret(Integer idHistoriquePret) {
        this.idHistoriquePret = idHistoriquePret;
    }

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }

    public LocalDateTime getDateHistoriquePret() {
        return dateHistoriquePret;
    }

    public void setDateHistoriquePret(LocalDateTime dateHistoriquePret) {
        this.dateHistoriquePret = dateHistoriquePret;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }
}