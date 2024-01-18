package com.example.mentesajava.service;


import com.example.mentesajava.dto.ContatoMedicoDto;
import com.example.mentesajava.dto.ContatoPrincipalDto;
import com.example.mentesajava.model.ContatoMedicoModel;
import com.example.mentesajava.model.ContatoPrincipalModel;
import com.example.mentesajava.repository.ContatoPricipalRepository;
import com.example.mentesajava.vo.ContatoPrincipalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ContatoPrincipalService {

    private static final String REGISTRO_CADASTRADO = "Contato Principal já cadastrado!";
    private static final String REGISTRO_NAO_ENCONTRADO = "Registro não encontrado!";

    @Autowired
    private ContatoPricipalRepository _contatoPricipalRepository;


    public ContatoPrincipalVO retornaContatoPrincipal() {

        List<ContatoPrincipalModel> listModel = this._contatoPricipalRepository.consultaConatoPrincipal();

        ContatoPrincipalVO vo = new ContatoPrincipalVO();
        if (!listModel.isEmpty()){
            vo.setId(listModel.get(0).getId());
            vo.setNome(listModel.get(0).getNome());
            vo.setTelefone(listModel.get(0).getTelefone());
        }

        return vo;

    }

    public ContatoPrincipalModel editar(ContatoPrincipalDto dto) {

        ContatoPrincipalModel model = new ContatoPrincipalModel();

        List<ContatoPrincipalModel> listModel = this._contatoPricipalRepository.consultaPorId(dto.getId());

        if (!listModel.isEmpty()){
            model.setId(listModel.get(0).getId());
            model.setNome(dto.getNome());
            model.setEmail(dto.getEmail());
            model.setTelefone(dto.getTelefone());
            model.setUpdateDate(LocalDateTime.now());
            model.setCreateDate(listModel.get(0).getCreateDate());
            model.setGrauParentesco(listModel.get(0).getGrauParentesco());

            model = this._contatoPricipalRepository.save(model);
        } else {
            throw new ValidationException(REGISTRO_NAO_ENCONTRADO);
        }

        return model;

    }

    public ContatoPrincipalModel criar(ContatoPrincipalDto dto) {

        List<ContatoPrincipalModel> listModel = this._contatoPricipalRepository.consultaConatoPrincipal();
        if (!listModel.isEmpty()) {
            throw new ValidationException(REGISTRO_CADASTRADO);
        }

        ContatoPrincipalModel model = new ContatoPrincipalModel();

        model.setNome(dto.getNome());
        model.setEmail(dto.getEmail());
        model.setTelefone(dto.getTelefone());
        model.setStatus(true);
        model.setGrauParentesco(dto.getGrau_parentesco());
        model.setCreateDate(LocalDateTime.now());
        model.setUpdateDate(LocalDateTime.now());

        model = this._contatoPricipalRepository.save(model);

        return model;
    }


}
