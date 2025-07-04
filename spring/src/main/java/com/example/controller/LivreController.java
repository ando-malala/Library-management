package com.example.controller;

import com.example.models.Livre;
import com.example.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @PostMapping
    public ResponseEntity<Livre> create(@RequestBody Livre livre) {
        Livre saved = livreService.save(livre);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livre> getById(@PathVariable Integer id) {
        Optional<Livre> livre = livreService.findById(id);
        return livre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Livre>> getAll() {
        List<Livre> livres = livreService.findAll();
        return new ResponseEntity<>(livres, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livre> update(@PathVariable Integer id, @RequestBody Livre livre) {
        Livre updated = livreService.update(id, livre);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        livreService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}