package com.example.controller;

import com.example.models.TypeLivre;
import com.example.services.TypeLivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type-livres")
public class TypeLivreController {

    @Autowired
    private TypeLivreService typeLivreService;

    @PostMapping
    public ResponseEntity<TypeLivre> create(@RequestBody TypeLivre typeLivre) {
        TypeLivre saved = typeLivreService.save(typeLivre);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeLivre> getById(@PathVariable Integer id) {
        Optional<TypeLivre> typeLivre = typeLivreService.findById(id);
        return typeLivre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TypeLivre>> getAll() {
        List<TypeLivre> typeLivres = typeLivreService.findAll();
        return new ResponseEntity<>(typeLivres, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeLivre> update(@PathVariable Integer id, @RequestBody TypeLivre typeLivre) {
        TypeLivre updated = typeLivreService.update(id, typeLivre);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        typeLivreService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}