package com.example.mentesajava.dto;

import lombok.Data;

@Data
public class ContatoMedicoDto {
    private String nome;
    private String email;
    private boolean status;
    private String telefone;
    private Enum EspeciAnEnum;
}
