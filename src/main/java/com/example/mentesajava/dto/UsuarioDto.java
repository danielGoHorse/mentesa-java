package com.example.mentesajava.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UsuarioDto {

    private String nome;
    private String id_fire;
    private String email;
    private boolean status;
    private String telefone;
}
