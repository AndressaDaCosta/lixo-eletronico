package com.projeto.lixo.eletronico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lixo_eletronico")
public class LixoEletronico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String descricao;

    // Constructors
    public LixoEletronico() {
    }

    public LixoEletronico(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
