package com.example.services;

import com.example.models.TypePret;
import com.example.repository.TypePretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypePretService {

    @Autowired
    private TypePretRepository typePretRepository;

    public TypePret save(TypePret typePret) {
        return typePretRepository.save(typePret);
    }

    public Optional<TypePret> findById(Integer id) {
        return typePretRepository.findById(id);
    }

    public List<TypePret> findAll() {
        return typePretRepository.findAll();
    }

    public TypePret update(Integer id, TypePret updatedTypePret) {
        Optional<TypePret> existing = typePretRepository.findById(id);
        if (existing.isPresent()) {
            TypePret typePret = existing.get();
            typePret.setLibelle(updatedTypePret.getLibelle());
            typePret.setDureeMax(updatedTypePret.getDureeMax());
            return typePretRepository.save(typePret);
        }
        return null;
    }

    public void delete(Integer id) {
        typePretRepository.deleteById(id);
    }
}