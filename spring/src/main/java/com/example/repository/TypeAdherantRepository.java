package com.example.repository;

import com.example.models.TypeAdherant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAdherantRepository extends JpaRepository<TypeAdherant, Integer> {
}