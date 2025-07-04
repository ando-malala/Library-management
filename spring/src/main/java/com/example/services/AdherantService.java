package com.example.services;

import com.example.models.Adherant;
import com.example.repository.AdherantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdherantService {

    @Autowired
    private AdherantRepository adherantRepository;

    public Adherant save(Adherant adherant) {
        return adherantRepository.save(adherant);
    }

    public Optional<Adherant> findById(Integer id) {
        return adherantRepository.findById(id);
    }

    public List<Adherant> findAll() {
        return adherantRepository.findAll();
    }

    public Adherant update(Integer id, Adherant updatedAdherant) {
        Optional<Adherant> existing = adherantRepository.findById(id);
        if (existing.isPresent()) {
            Adherant adherant = existing.get();
            adherant.setNom(updatedAdherant.getNom());
            adherant.setPrenom(updatedAdherant.getPrenom());
            adherant.setTelephone(updatedAdherant.getTelephone());
            adherant.setTypeAdherant(updatedAdherant.getTypeAdherant());
            return adherantRepository.save(adherant);
        }
        return null;
    }

    public void delete(Integer id) {
        adherantRepository.deleteById(id);
    }
}