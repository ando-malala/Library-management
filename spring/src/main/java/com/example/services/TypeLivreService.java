package com.example.services;

import com.example.models.TypeLivre;
import com.example.repository.TypeLivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeLivreService {

    @Autowired
    private TypeLivreRepository typeLivreRepository;

    public TypeLivre save(TypeLivre typeLivre) {
        return typeLivreRepository.save(typeLivre);
    }

    public Optional<TypeLivre> findById(Integer id) {
        return typeLivreRepository.findById(id);
    }

    public List<TypeLivre> findAll() {
        return typeLivreRepository.findAll();
    }

    public TypeLivre update(Integer id, TypeLivre updatedTypeLivre) {
        Optional<TypeLivre> existing = typeLivreRepository.findById(id);
        if (existing.isPresent()) {
            TypeLivre typeLivre = existing.get();
            typeLivre.setLibelle(updatedTypeLivre.getLibelle());
            return typeLivreRepository.save(typeLivre);
        }
        return null;
    }

    public void delete(Integer id) {
        typeLivreRepository.deleteById(id);
    }
}