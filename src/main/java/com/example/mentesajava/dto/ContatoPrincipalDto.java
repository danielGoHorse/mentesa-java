package com.example.mentesajava.dto;


import lombok.Data;

import java.util.UUID;

@Data
public class ContatoPrincipalDto {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Integer grau_parentesco;

}
