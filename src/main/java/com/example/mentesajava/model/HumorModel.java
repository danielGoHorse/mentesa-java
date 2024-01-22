package com.example.mentesajava.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity
@Table(name = "tb_humor")
public class HumorModel {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "status")
    private boolean status;
}
