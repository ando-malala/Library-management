package com.example.services;

import com.example.models.Pret;
import com.example.repository.PretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PretService {

    @Autowired
    private PretRepository pretRepository;

    public Pret save(Pret pret) {
        return pretRepository.save(pret);
    }

    public Optional<Pret> findById(Integer id) {
        return pretRepository.findById(id);
    }

    public List<Pret> findAll() {
        return pretRepository.findAll();
    }

    public Pret update(Integer id, Pret updatedPret) {
        Optional<Pret> existing = pretRepository.findById(id);
        if (existing.isPresent()) {
            Pret pret = existing.get();
            pret.setLivre(updatedPret.getLivre());
            pret.setAdherant(updatedPret.getAdherant());
            pret.setTypePret(updatedPret.getTypePret());
            pret.setBibliothecaire(updatedPret.getBibliothecaire());
            pret.setDateDebut(updatedPret.getDateDebut());
            pret.setDateFin(updatedPret.getDateFin());
            pret.setDuree(updatedPret.getDuree());
            return pretRepository.save(pret);
        }
        return null;
    }

    public void delete(Integer id) {
        pretRepository.deleteById(id);
    }
}