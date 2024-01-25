package com.example.mentesajava.vo;

import lombok.Data;

import java.util.UUID;
@Data
public class UsuarioVO {

    private UUID id;
    private String id_fire;
    private String nome;
    private String telefone;
    private String email;
    private boolean status;

}
