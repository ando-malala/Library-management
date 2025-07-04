package com.example.services;

import com.example.models.Bibliothecaire;
import com.example.repository.BibliothecaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliothecaireService {

    @Autowired
    private BibliothecaireRepository bibliothecaireRepository;

    public Bibliothecaire save(Bibliothecaire bibliothecaire) {
        return bibliothecaireRepository.save(bibliothecaire);
    }

    public Optional<Bibliothecaire> findById(Integer id) {
        return bibliothecaireRepository.findById(id);
    }

    public List<Bibliothecaire> findAll() {
        return bibliothecaireRepository.findAll();
    }

    public Bibliothecaire update(Integer id, Bibliothecaire updatedBibliothecaire) {
        Optional<Bibliothecaire> existing = bibliothecaireRepository.findById(id);
        if (existing.isPresent()) {
            Bibliothecaire bibliothecaire = existing.get();
            bibliothecaire.setNom(updatedBibliothecaire.getNom());
            bibliothecaire.setPrenom(updatedBibliothecaire.getPrenom());
            bibliothecaire.setEmail(updatedBibliothecaire.getEmail());
            bibliothecaire.setMotDePasse(updatedBibliothecaire.getMotDePasse());
            return bibliothecaireRepository.save(bibliothecaire);
        }
        return null;
    }

    public void delete(Integer id) {
        bibliothecaireRepository.deleteById(id);
    }
}