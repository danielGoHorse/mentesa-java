package com.example.mentesajava.repository;

import com.example.mentesajava.model.ContatoMedicoModel;
import com.example.mentesajava.model.ContatoPrincipalModel;
import com.example.mentesajava.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Query(value = "SELECT c" +
            " FROM UsuarioModel c" +
            " WHERE c.id = :id")
    List<UsuarioModel> consultaPorId(@Param("id") UUID id);

    @Query(value = "SELECT c" +
            " FROM ContatoPrincipalModel c")
    List<UsuarioModel> consultaUsuario();
}
