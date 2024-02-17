package com.example.mentesajava.repository;

import com.example.mentesajava.model.HumorHistoricoModel;
import com.example.mentesajava.model.MusicaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<MusicaModel, Long> {

    @Query(value = "SELECT c" +
            " FROM MusicaModel c")
    List<MusicaModel> consultaMusica();

}