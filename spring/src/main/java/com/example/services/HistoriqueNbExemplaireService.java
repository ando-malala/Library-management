package com.example.services;

import com.example.models.HistoriqueNbExemplaire;
import com.example.repository.HistoriqueNbExemplaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriqueNbExemplaireService {

    @Autowired
    private HistoriqueNbExemplaireRepository historiqueNbExemplaireRepository;

    public HistoriqueNbExemplaire save(HistoriqueNbExemplaire historiqueNbExemplaire) {
        return historiqueNbExemplaireRepository.save(historiqueNbExemplaire);
    }

    public Optional<HistoriqueNbExemplaire> findById(Integer id) {
        return historiqueNbExemplaireRepository.findById(id);
    }

    public List<HistoriqueNbExemplaire> findAll() {
        return historiqueNbExemplaireRepository.findAll();
    }

    public HistoriqueNbExemplaire update(Integer id, HistoriqueNbExemplaire updatedHistoriqueNbExemplaire) {
        Optional<HistoriqueNbExemplaire> existing = historiqueNbExemplaireRepository.findById(id);
        if (existing.isPresent()) {
            HistoriqueNbExemplaire historiqueNbExemplaire = existing.get();
            historiqueNbExemplaire.setLivre(updatedHistoriqueNbExemplaire.getLivre());
            historiqueNbExemplaire.setExemplaireDisponible(updatedHistoriqueNbExemplaire.getExemplaireDisponible());
            historiqueNbExemplaire.setNombreDisponible(updatedHistoriqueNbExemplaire.getNombreDisponible());
            return historiqueNbExemplaireRepository.save(historiqueNbExemplaire);
        }
        return null;
    }

    public void delete(Integer id) {
        historiqueNbExemplaireRepository.deleteById(id);
    }
}