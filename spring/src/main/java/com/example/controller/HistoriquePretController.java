package com.example.controller;

import com.example.models.HistoriquePret;
import com.example.services.HistoriquePretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historique-prets")
public class HistoriquePretController {

    @Autowired
    private HistoriquePretService historiquePretService;

    @PostMapping
    public ResponseEntity<HistoriquePret> create(@RequestBody HistoriquePret historiquePret) {
        HistoriquePret saved = historiquePretService.save(historiquePret);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriquePret> getById(@PathVariable Integer id) {
        Optional<HistoriquePret> historiquePret = historiquePretService.findById(id);
        return historiquePret.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<HistoriquePret>> getAll() {
        List<HistoriquePret> historiquePrets = historiquePretService.findAll();
        return new ResponseEntity<>(historiquePrets, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriquePret> update(@PathVariable Integer id, @RequestBody HistoriquePret historiquePret) {
        HistoriquePret updated = historiquePretService.update(id, historiquePret);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        historiquePretService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}