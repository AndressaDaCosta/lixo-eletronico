package com.projeto.lixo.eletronico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "materiais_ponto_coleta")
public class MateriaisPontoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ponto_de_coleta_id")
    private PontoDeColeta pontoDeColeta;

    @ManyToOne
    @JoinColumn(name = "lixo_eletronico_id")
    private LixoEletronico lixoEletronico;

    private Integer capacidadeMaxima;

    // Constructors
    public MateriaisPontoColeta() {
    }

    public MateriaisPontoColeta(PontoDeColeta ponto, LixoEletronico lixo, Integer capacidade) {
        this.pontoDeColeta = ponto;
        this.lixoEletronico = lixo;
        this.capacidadeMaxima = capacidade;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public PontoDeColeta getPontoDeColeta() {
        return pontoDeColeta;
    }

    public void setPontoDeColeta(PontoDeColeta pontoDeColeta) {
        this.pontoDeColeta = pontoDeColeta;
    }

    public LixoEletronico getLixoEletronico() {
        return lixoEletronico;
    }

    public void setLixoEletronico(LixoEletronico lixoEletronico) {
        this.lixoEletronico = lixoEletronico;
    }

    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(Integer capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
}
