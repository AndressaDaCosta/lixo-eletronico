package com.projeto.lixo.eletronico.service;

import com.projeto.lixo.eletronico.dto.*;
import com.projeto.lixo.eletronico.model.*;
import com.projeto.lixo.eletronico.repository.PontoDeColetaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PontoDeColetaService {

    @Autowired
    private PontoDeColetaRepository repository;

    @Transactional
    public PontoDeColetaResponseDTO create(PontoDeColetaRequestDTO dto) {
        PontoDeColeta ponto = new PontoDeColeta();
        ponto.setNome(dto.nome);
        ponto.setEndereco(dto.endereco);
        ponto.setDiaDeColeta(dto.diaDeColeta);

        for (MaterialDTO matDto : dto.materiais) {
            MateriaisPontoColeta m = new MateriaisPontoColeta();
            m.setTipoMaterial(matDto.tipoMaterial);
            m.setCapacidadeMaxima(matDto.capacidadeMaxima);
            m.setPontoDeColeta(ponto);
            ponto.getMateriais().add(m);
        }

        return toResponseDTO(repository.save(ponto));
    }

    public List<PontoDeColetaResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PontoDeColetaResponseDTO findById(Long id) {
        return toResponseDTO(repository.findById(id).orElseThrow());
    }

    public PontoDeColetaResponseDTO update(Long id, PontoDeColetaRequestDTO dto) {
        PontoDeColeta ponto = repository.findById(id).orElseThrow();
        ponto.setNome(dto.nome);
        ponto.setEndereco(dto.endereco);
        ponto.setDiaDeColeta(dto.diaDeColeta);
        ponto.getMateriais().clear();

        for (MaterialDTO matDto : dto.materiais) {
            MateriaisPontoColeta m = new MateriaisPontoColeta();
            m.setTipoMaterial(matDto.tipoMaterial);
            m.setCapacidadeMaxima(matDto.capacidadeMaxima);
            m.setPontoDeColeta(ponto);
            ponto.getMateriais().add(m);
        }

        return toResponseDTO(repository.save(ponto));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<PontoDeColetaResponseDTO> findByTipoMaterialContaining(String material) {
        return repository.findAll().stream()
                .filter(ponto -> ponto.getMateriais().stream()
                        .anyMatch(m -> m.getTipoMaterial().toLowerCase().contains(material.toLowerCase())))
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Método auxiliar para montar o DTO de resposta
    private PontoDeColetaResponseDTO toResponseDTO(PontoDeColeta ponto) {
        PontoDeColetaResponseDTO dto = new PontoDeColetaResponseDTO();
        dto.id = ponto.getId();
        dto.nome = ponto.getNome();
        dto.endereco = ponto.getEndereco();
        dto.diaDeColeta = ponto.getDiaDeColeta();
        dto.materiais = ponto.getMateriais().stream().map(material -> {
            MaterialResponseDTO m = new MaterialResponseDTO();
            m.id = material.getId();
            m.tipoMaterial = material.getTipoMaterial();
            m.capacidadeMaxima = material.getCapacidadeMaxima();
            // Não retorna pontoDeColeta aqui!
            return m;
        }).collect(Collectors.toList());
        return dto;
    }
}
