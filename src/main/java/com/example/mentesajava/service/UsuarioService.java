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


//    public UsuarioVO retornaUsuario() {
//
//        List<UsuarioModel> listModel = this._usuarioRepository.consultaUsuario();
//
//        UsuarioVO vo = new UsuarioVO();
//        if (!listModel.isEmpty()){
//            vo.setId(listModel.get(0).getId());
//            vo.setId_fire(listModel.get(0).getId_fire());
//            vo.setNome(listModel.get(0).getNome());
//            vo.setTelefone(listModel.get(0).getTelefone());
//            vo.setEmail(listModel.get(0).getEmail());
//        }
//
//        return vo;
//
//    }
    public UsuarioVO retornaUsuarioByFire(String id_fire) {

        List<UsuarioModel> listModel = this._usuarioRepository.consultaPorIdFire(id_fire);

        UsuarioVO vo = new UsuarioVO();
        if (!listModel.isEmpty()){
            vo.setId(listModel.get(0).getId());
            vo.setId_fire(listModel.get(0).getId_fire());
            vo.setNome(listModel.get(0).getNome());
            vo.setTelefone(listModel.get(0).getTelefone());
            vo.setEmail(listModel.get(0).getEmail());

            return vo;
        }else {
            throw new ValidationException(REGISTRO_NAO_ENCONTRADO);
        }

    }


    public UsuarioModel criar(UsuarioDto dto) {

        List<UsuarioModel> listModel = this._usuarioRepository.consultaUsuario();
        if (!listModel.isEmpty()) {
            throw new ValidationException(REGISTRO_CADASTRADO);
        }

        UsuarioModel model = new UsuarioModel();

        model.setId_fire(dto.getId_fire());
        model.setNome(dto.getNome());
        model.setEmail(dto.getEmail());
        model.setTelefone(dto.getTelefone());
        model.setStatus(false);
        model.setCreateDate(LocalDateTime.now());
        model.setUpdateDate(LocalDateTime.now());

        model = this._usuarioRepository.save(model);

        return model;
    }

}
