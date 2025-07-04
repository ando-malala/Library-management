package com.example.services;

import com.example.models.TypeAdherant;
import com.example.repository.TypeAdherantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeAdherantService {

    @Autowired
    private TypeAdherantRepository typeAdherantRepository;

    public TypeAdherant save(TypeAdherant typeAdherant) {
        return typeAdherantRepository.save(typeAdherant);
    }

    public Optional<TypeAdherant> findById(Integer id) {
        return typeAdherantRepository.findById(id);
    }

    public List<TypeAdherant> findAll() {
        return typeAdherantRepository.findAll();
    }

    public TypeAdherant update(Integer id, TypeAdherant updatedTypeAdherant) {
        Optional<TypeAdherant> existing = typeAdherantRepository.findById(id);
        if (existing.isPresent()) {
            TypeAdherant typeAdherant = existing.get();
            typeAdherant.setLibelle(updatedTypeAdherant.getLibelle());
            return typeAdherantRepository.save(typeAdherant);
        }
        return null;
    }

    public void delete(Integer id) {
        typeAdherantRepository.deleteById(id);
    }
}