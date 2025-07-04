package com.example.controller;

import com.example.models.TypePret;
import com.example.services.TypePretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type-prets")
public class TypePretController {

    @Autowired
    private TypePretService typePretService;

    @PostMapping
    public ResponseEntity<TypePret> create(@RequestBody TypePret typePret) {
        TypePret saved = typePretService.save(typePret);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypePret> getById(@PathVariable Integer id) {
        Optional<TypePret> typePret = typePretService.findById(id);
        return typePret.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TypePret>> getAll() {
        List<TypePret> typePrets = typePretService.findAll();
        return new ResponseEntity<>(typePrets, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypePret> update(@PathVariable Integer id, @RequestBody TypePret typePret) {
        TypePret updated = typePretService.update(id, typePret);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        typePretService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}