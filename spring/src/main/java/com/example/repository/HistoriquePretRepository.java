package com.example.repository;

import com.example.models.HistoriquePret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriquePretRepository extends JpaRepository<HistoriquePret, Integer> {
}