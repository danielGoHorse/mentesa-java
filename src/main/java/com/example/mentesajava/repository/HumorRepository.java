package com.example.mentesajava.repository;

import com.example.mentesajava.model.HumorModel;
import com.example.mentesajava.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface HumorRepository  extends JpaRepository<HumorModel, Long> {

    @Query(value = "SELECT c" +
            " FROM HumorModel c" +
            " WHERE c.id = :id")
    List<HumorModel> consultaPorId(@Param("id") UUID id);

    @Query(value = "SELECT c" +
            " FROM ContatoPrincipalModel c")
    List<HumorModel> consultaHumor();
}