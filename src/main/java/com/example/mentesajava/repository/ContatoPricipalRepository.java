package com.example.mentesajava.repository;

import com.example.mentesajava.model.ContatoPrincipalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContatoPricipalRepository extends JpaRepository<ContatoPrincipalModel, Long> {
    @Query(value = "SELECT c" +
            " FROM ContatoPrincipalModel c" +
            " WHERE c.id = :id")
    List<ContatoPrincipalModel> consultaPorId(@Param("id") UUID id);

    @Query(value = "SELECT c" +
            " FROM ContatoPrincipalModel c" +
            " WHERE c.id = :idUsuario")
    List<ContatoPrincipalModel> consultaPorIdUsuario(@Param("idUsuario") String idUsuario);

    @Query(value = "SELECT c" +
            " FROM ContatoPrincipalModel c")
    List<ContatoPrincipalModel> consultaConatoPrincipal();


}
