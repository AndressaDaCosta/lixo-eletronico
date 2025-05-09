package com.projeto.lixo.eletronico.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ponto_de_coleta")
public class PontoDeColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String diaDeColeta;

    @OneToMany(mappedBy = "pontoDeColeta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MateriaisPontoColeta> materiais = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDiaDeColeta() {
        return diaDeColeta;
    }

    public void setDiaDeColeta(String diaDeColeta) {
        this.diaDeColeta = diaDeColeta;
    }

    public List<MateriaisPontoColeta> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<MateriaisPontoColeta> materiais) {
        this.materiais = materiais;
    }
}
