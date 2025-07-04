package com.example.controller;

import com.example.models.Pret;
import com.example.services.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prets")
public class PretController {

    @Autowired
    private PretService pretService;

    @PostMapping
    public ResponseEntity<Pret> create(@RequestBody Pret pret) {
        Pret saved = pretService.save(pret);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pret> getById(@PathVariable Integer id) {
        Optional<Pret> pret = pretService.findById(id);
        return pret.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Pret>> getAll() {
        List<Pret> prets = pretService.findAll();
        return new ResponseEntity<>(prets, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pret> update(@PathVariable Integer id, @RequestBody Pret pret) {
        Pret updated = pretService.update(id, pret);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pretService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}