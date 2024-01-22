package com.example.mentesajava.service;

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


    public UsuarioVO retornaUsuario() {

        List<UsuarioModel> listModel = this._usuarioRepository.consultaUsuario();

        UsuarioVO vo = new UsuarioVO();
        if (!listModel.isEmpty()){
            vo.setId(listModel.get(0).getId());
            vo.setNome(listModel.get(0).getNome());
            vo.setTelefone(listModel.get(0).getTelefone());
        }

        return vo;

    }

}
