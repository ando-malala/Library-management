package com.example.repository;

import com.example.models.HistoriqueNbExemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueNbExemplaireRepository extends JpaRepository<HistoriqueNbExemplaire, Integer> {
}