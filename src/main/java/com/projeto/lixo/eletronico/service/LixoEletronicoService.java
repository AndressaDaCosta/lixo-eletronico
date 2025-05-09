package com.projeto.lixo.eletronico.service;

import com.projeto.lixo.eletronico.dto.*;
import com.projeto.lixo.eletronico.model.LixoEletronico;
import com.projeto.lixo.eletronico.repository.LixoEletronicoRepository;
import com.projeto.lixo.eletronico.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LixoEletronicoService {

    @Autowired
    private LixoEletronicoRepository repository;

    public LixoEletronicoResponseDTO create(LixoEletronicoRequestDTO dto) {
        LixoEletronico lixo = new LixoEletronico(dto.getTipo(), dto.getDescricao());
        return toResponseDTO(repository.save(lixo));
    }

    public List<LixoEletronicoResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public LixoEletronicoResponseDTO findById(Long id) {
        LixoEletronico lixo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lixo eletrônico não encontrado com ID: " + id));
        return toResponseDTO(lixo);
    }

    public LixoEletronicoResponseDTO update(Long id, LixoEletronicoRequestDTO dto) {
        LixoEletronico lixo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lixo eletrônico não encontrado com ID: " + id));
        lixo.setTipo(dto.getTipo());
        lixo.setDescricao(dto.getDescricao());
        return toResponseDTO(repository.save(lixo));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Lixo eletrônico não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }

    private LixoEletronicoResponseDTO toResponseDTO(LixoEletronico entity) {
        LixoEletronicoResponseDTO dto = new LixoEletronicoResponseDTO();
        dto.setId(entity.getId());
        dto.setTipo(entity.getTipo());
        dto.setDescricao(entity.getDescricao());
        return dto;
    }
}
