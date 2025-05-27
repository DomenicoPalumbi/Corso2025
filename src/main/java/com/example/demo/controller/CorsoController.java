package com.example.demo.controller;

import com.example.demo.data.dto.*;
import com.example.demo.service.CorsoService;
import com.example.demo.service.DiscenteService;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corsi")
public class CorsoController {

    @Autowired
    private CorsoService corsoService;

    @Autowired
    private DocenteService docenteService;

    @Autowired
    private DiscenteService discenteService;

    @GetMapping("/lista")
    public ResponseEntity<List<CorsoDTO>> listaCorsi() {
        return ResponseEntity.ok(corsoService.getAllCorsiDTO());
    }

    @PostMapping("/nuovo")
    public ResponseEntity<CorsoDTO> saveCorso(@RequestBody CorsoFullDTO corsoFullDTO) {
        return ResponseEntity.ok(corsoService.saveCorso(corsoFullDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CorsoDTO> updateCorso(
            @PathVariable Long id,
            @RequestBody CorsoFullDTO corsoFullDTO) {
        return ResponseEntity.ok(corsoService.updateCorso(id, corsoFullDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCorso(@PathVariable Long id) {
        corsoService.deleteCorso(id);
        return ResponseEntity.ok().build();
    }
}