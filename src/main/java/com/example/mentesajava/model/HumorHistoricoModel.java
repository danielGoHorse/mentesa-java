package com.example.mentesajava.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity
@Table(name = "tb_humor_historico")
public class HumorHistoricoModel {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "humor")
    private Integer humor;

    @Column(name = "data_humor")
    private LocalDateTime dataHumor;

    @Column(name = "mensagem")
    private String mensagem;

    //@Column(name = "id_usuario")
    //private String humorDescricao;
}
