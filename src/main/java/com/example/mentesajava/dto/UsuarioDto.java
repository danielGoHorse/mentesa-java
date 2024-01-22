package com.example.mentesajava.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UsuarioDto {
    private UUID id;
    private String nome;
    private String email;
    private boolean status;
    private String telefone;
}
