package com.example.mentesajava.model;


import jakarta.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;


@Data
public class ContatoMedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    //Enum
    //@Column(name = "especialidade")
    //private String especialidade;
}
