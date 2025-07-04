package com.example.services;

import com.example.models.Livre;
import com.example.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public Livre save(Livre livre) {
        return livreRepository.save(livre);
    }

    public Optional<Livre> findById(Integer id) {
        return livreRepository.findById(id);
    }

    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    public Livre update(Integer id, Livre updatedLivre) {
        Optional<Livre> existing = livreRepository.findById(id);
        if (existing.isPresent()) {
            Livre livre = existing.get();
            livre.setTitre(updatedLivre.getTitre());
            livre.setLivreEdition(updatedLivre.getLivreEdition());
            livre.setAuteur(updatedLivre.getAuteur());
            livre.setDateSortie(updatedLivre.getDateSortie());
            livre.setTypeLivre(updatedLivre.getTypeLivre());
            livre.setDateAjout(updatedLivre.getDateAjout());
            livre.setNombreExemplaires(updatedLivre.getNombreExemplaires());
            return livreRepository.save(livre);
        }
        return null;
    }

    public void delete(Integer id) {
        livreRepository.deleteById(id);
    }
}