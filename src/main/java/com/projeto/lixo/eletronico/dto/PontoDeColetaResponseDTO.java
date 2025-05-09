package com.projeto.lixo.eletronico.dto;

import java.util.List;

public class PontoDeColetaResponseDTO {
    public Long id;
    public String nome;
    public String endereco;
    public String diaDeColeta;
    public List<MaterialResponseDTO> materiais;
}
