package com.projeto.lixo.eletronico.controller;

import com.projeto.lixo.eletronico.dto.PontoDeColetaRequestDTO;
import com.projeto.lixo.eletronico.dto.PontoDeColetaResponseDTO;
import com.projeto.lixo.eletronico.service.PontoDeColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collection-points")
public class PontoDeColetaController {

    @Autowired
    private PontoDeColetaService service;

    @PostMapping
    public ResponseEntity<PontoDeColetaResponseDTO> create(@RequestBody PontoDeColetaRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<PontoDeColetaResponseDTO>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoDeColetaResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontoDeColetaResponseDTO> update(@PathVariable Long id,
            @RequestBody PontoDeColetaRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/electronic-waste/name/{name}")
    public ResponseEntity<List<PontoDeColetaResponseDTO>> getByElectronicWasteName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByTipoMaterialContaining(name));
    }
}
