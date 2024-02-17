package com.example.mentesajava.repository;

import com.example.mentesajava.model.HumorHistoricoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface HumorHistoricoRepository extends JpaRepository<HumorHistoricoModel, Long> {

    @Query(value = "SELECT c" +
            " FROM HumorHistoricoModel c")
    List<HumorHistoricoModel> consultaHumorHistorico();

}