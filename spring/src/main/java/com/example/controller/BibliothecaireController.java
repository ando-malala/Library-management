package com.example.controller;

import com.example.models.Bibliothecaire;
import com.example.services.BibliothecaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bibliothecaires")
public class BibliothecaireController {

    @Autowired
    private BibliothecaireService bibliothecaireService;

    @PostMapping
    public ResponseEntity<Bibliothecaire> create(@RequestBody Bibliothecaire bibliothecaire) {
        Bibliothecaire saved = bibliothecaireService.save(bibliothecaire);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bibliothecaire> getById(@PathVariable Integer id) {
        Optional<Bibliothecaire> bibliothecaire = bibliothecaireService.findById(id);
        return bibliothecaire.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Bibliothecaire>> getAll() {
        List<Bibliothecaire> bibliothecaires = bibliothecaireService.findAll();
        return new ResponseEntity<>(bibliothecaires, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bibliothecaire> update(@PathVariable Integer id, @RequestBody Bibliothecaire bibliothecaire) {
        Bibliothecaire updated = bibliothecaireService.update(id, bibliothecaire);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bibliothecaireService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}