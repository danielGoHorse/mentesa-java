package com.example.mentesajava.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity
@Table(name = "tb_musica")
public class MusicaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "nome_musica")
    private String nomeMusica;

    @Column(name = "link")
    private String link;

    //Enum
    //@Column(name = "especialidade")
    //private String especialidade;
}
