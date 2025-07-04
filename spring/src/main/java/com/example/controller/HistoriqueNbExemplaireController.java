package com.example.controller;

import com.example.models.HistoriqueNbExemplaire;
import com.example.services.HistoriqueNbExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historique-exemplaires")
public class HistoriqueNbExemplaireController {

    @Autowired
    private HistoriqueNbExemplaireService historiqueNbExemplaireService;

    @PostMapping
    public ResponseEntity<HistoriqueNbExemplaire> create(@RequestBody HistoriqueNbExemplaire historiqueNbExemplaire) {
        HistoriqueNbExemplaire saved = historiqueNbExemplaireService.save(historiqueNbExemplaire);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriqueNbExemplaire> getById(@PathVariable Integer id) {
        Optional<HistoriqueNbExemplaire> historiqueNbExemplaire = historiqueNbExemplaireService.findById(id);
        return historiqueNbExemplaire.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<HistoriqueNbExemplaire>> getAll() {
        List<HistoriqueNbExemplaire> historiqueNbExemplaires = historiqueNbExemplaireService.findAll();
        return new ResponseEntity<>(historiqueNbExemplaires, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriqueNbExemplaire> update(@PathVariable Integer id, @RequestBody HistoriqueNbExemplaire historiqueNbExemplaire) {
        HistoriqueNbExemplaire updated = historiqueNbExemplaireService.update(id, historiqueNbExemplaire);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        historiqueNbExemplaireService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}