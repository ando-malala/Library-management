package com.example.controller;

import com.example.models.Adherant;
import com.example.services.AdherantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adherants")
public class AdherantController {

    @Autowired
    private AdherantService adherantService;

    @PostMapping
    public ResponseEntity<Adherant> create(@RequestBody Adherant adherant) {
        Adherant saved = adherantService.save(adherant);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adherant> getById(@PathVariable Integer id) {
        Optional<Adherant> adherant = adherantService.findById(id);
        return adherant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Adherant>> getAll() {
        List<Adherant> adherants = adherantService.findAll();
        return new ResponseEntity<>(adherants, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adherant> update(@PathVariable Integer id, @RequestBody Adherant adherant) {
        Adherant updated = adherantService.update(id, adherant);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        adherantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}