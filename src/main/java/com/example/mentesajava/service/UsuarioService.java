package com.example.mentesajava.service;

import com.example.mentesajava.dto.ContatoPrincipalDto;
import com.example.mentesajava.dto.UsuarioDto;
import com.example.mentesajava.model.ContatoMedicoModel;
import com.example.mentesajava.model.ContatoPrincipalModel;
import com.example.mentesajava.model.UsuarioModel;
import com.example.mentesajava.repository.ContatoMedicoRepository;
import com.example.mentesajava.repository.ContatoPricipalRepository;
import com.example.mentesajava.repository.UsuarioRepository;
import com.example.mentesajava.vo.ContatoPrincipalVO;
import com.example.mentesajava.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Service
public class UsuarioService {

    private static final String REGISTRO_CADASTRADO = "Usuário já cadastrado!";
    private static final String REGISTRO_NAO_ENCONTRADO = "Usuário não encontrado!";

    @Autowired
    private UsuarioRepository _usuarioRepository;

    public UsuarioVO consultaUsuarioByFire(String idFire) {

        //UsuarioModel model = new UsuarioModel();
        UsuarioModel model = this._usuarioRepository.consultaPorIdFire(idFire);
        UsuarioVO vo = new UsuarioVO();

        if (model.getIdFire() != null) {
            vo.setId(model.getId());
            vo.setId_fire(model.getIdFire());
            vo.setNome(model.getNome());
            vo.setStatus(model.isStatus());
            vo.setTelefone(model.getTelefone());
            vo.setEmail(model.getEmail());
        } else {
            throw new ValidationException(REGISTRO_NAO_ENCONTRADO);
        }

        return vo;
    }


    public UsuarioModel criar(UsuarioDto dto) {

        //UsuarioModel model = new UsuarioModel();
        UsuarioModel model = this._usuarioRepository.consultaPorIdFire(dto.getIdFire());

        if (model.getIdFire() != null) {
            model.setIdFire(dto.getIdFire());
            model.setNome(dto.getNome());
            model.setEmail(dto.getEmail());
            model.setTelefone(dto.getTelefone());
            model.setStatus(false);
            model.setCreateDate(LocalDateTime.now());
            model.setUpdateDate(LocalDateTime.now());

            model = this._usuarioRepository.save(model);
        }

        return model;
    }

    public UsuarioModel editar(UsuarioDto dto) {

        UsuarioModel model = new UsuarioModel();
        List<UsuarioModel> listModel = this._usuarioRepository.consultaListaUsuarioPorId(dto.getIdFire());

        if(!listModel.isEmpty()){
            listModel.get(0).setIdFire(dto.getIdFire());
            listModel.get(0).setNome(dto.getNome());
            listModel.get(0).setEmail(dto.getEmail());
            listModel.get(0).setTelefone(dto.getTelefone());
            listModel.get(0).setStatus(true);
            listModel.get(0).setUpdateDate(LocalDateTime.now());

            model = this._usuarioRepository.save(listModel.get(0));
        } else {
            throw new ValidationException(REGISTRO_NAO_ENCONTRADO);
        }
        return model;
    }
}


