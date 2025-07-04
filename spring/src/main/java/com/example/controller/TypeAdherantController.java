package com.example.controller;

import com.example.models.TypeAdherant;
import com.example.services.TypeAdherantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type-adherants")
public class TypeAdherantController {

    @Autowired
    private TypeAdherantService typeAdherantService;

    @PostMapping
    public ResponseEntity<TypeAdherant> create(@RequestBody TypeAdherant typeAdherant) {
        TypeAdherant saved = typeAdherantService.save(typeAdherant);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeAdherant> getById(@PathVariable Integer id) {
        Optional<TypeAdherant> typeAdherant = typeAdherantService.findById(id);
        return typeAdherant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TypeAdherant>> getAll() {
        List<TypeAdherant> typeAdherants = typeAdherantService.findAll();
        return new ResponseEntity<>(typeAdherants, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeAdherant> update(@PathVariable Integer id, @RequestBody TypeAdherant typeAdherant) {
        TypeAdherant updated = typeAdherantService.update(id, typeAdherant);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        typeAdherantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}