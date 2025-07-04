package com.example.repository;

import com.example.models.TypeLivre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeLivreRepository extends JpaRepository<TypeLivre, Integer> {
}