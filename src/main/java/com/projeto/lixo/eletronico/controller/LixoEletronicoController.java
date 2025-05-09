package com.projeto.lixo.eletronico.controller;

import com.projeto.lixo.eletronico.dto.*;
import com.projeto.lixo.eletronico.service.LixoEletronicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electronic-waste")
public class LixoEletronicoController {

    @Autowired
    private LixoEletronicoService service;

    @PostMapping
    public ResponseEntity<LixoEletronicoResponseDTO> create(@Valid @RequestBody LixoEletronicoRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public List<LixoEletronicoResponseDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LixoEletronicoResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LixoEletronicoResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody LixoEletronicoRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
