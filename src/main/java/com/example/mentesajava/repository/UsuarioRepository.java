package com.example.mentesajava.repository;

import com.example.mentesajava.model.ContatoMedicoModel;
import com.example.mentesajava.model.ContatoPrincipalModel;
import com.example.mentesajava.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Query(value = "SELECT c" +
            " FROM UsuarioModel c" +
            " WHERE c.id_fire = :id_fire")
    List<UsuarioModel> consultaPorIdFire (@Param("id_fire") String id_fire);

    @Query(value = "SELECT c" +
            " FROM UsuarioModel c")
    List<UsuarioModel> consultaUsuario();
}
