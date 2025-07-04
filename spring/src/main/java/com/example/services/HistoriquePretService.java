package com.example.services;

import com.example.models.HistoriquePret;
import com.example.repository.HistoriquePretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriquePretService {

    @Autowired
    private HistoriquePretRepository historiquePretRepository;

    public HistoriquePret save(HistoriquePret historiquePret) {
        return historiquePretRepository.save(historiquePret);
    }

    public Optional<HistoriquePret> findById(Integer id) {
        return historiquePretRepository.findById(id);
    }

    public List<HistoriquePret> findAll() {
        return historiquePretRepository.findAll();
    }

    public HistoriquePret update(Integer id, HistoriquePret updatedHistoriquePret) {
        Optional<HistoriquePret> existing = historiquePretRepository.findById(id);
        if (existing.isPresent()) {
            HistoriquePret historiquePret = existing.get();
            historiquePret.setPret(updatedHistoriquePret.getPret());
            historiquePret.setDateHistoriquePret(updatedHistoriquePret.getDateHistoriquePret());
            historiquePret.setStatut(updatedHistoriquePret.getStatut());
            return historiquePretRepository.save(historiquePret);
        }
        return null;
    }

    public void delete(Integer id) {
        historiquePretRepository.deleteById(id);
    }
}