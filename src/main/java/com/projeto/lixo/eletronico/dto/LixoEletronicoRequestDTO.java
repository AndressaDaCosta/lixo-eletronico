package com.projeto.lixo.eletronico.dto;

import jakarta.validation.constraints.NotBlank;

public class LixoEletronicoRequestDTO {

    @NotBlank(message = "O tipo do lixo eletrônico é obrigatório")
    private String tipo;

    private String descricao;

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
