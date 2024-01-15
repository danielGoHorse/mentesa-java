package com.example.mentesajava.service;


import com.example.mentesajava.dto.ContatoMedicoDto;
import com.example.mentesajava.model.ContatoMedicoModel;
import com.example.mentesajava.repository.ContatoMedicoRepository;
import com.example.mentesajava.vo.ContatoPrincipalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ContatoMedicoService {

    private static final String REGISTRO_NAO_ENCONTRADO = "Registro não encontrado!";

    @Autowired
    private ContatoMedicoRepository _contatoMedicoRepository;


    public ContatoPrincipalVO retornaContatoPrincipal(Long id) {

        List<ContatoMedicoModel> listModel = this._contatoMedicoRepository.consultaPorId(id);

        ContatoPrincipalVO vo = new ContatoPrincipalVO();
        if (!listModel.isEmpty()) {
//            vo.setId(listModel.get(0).getId());
            vo.setNome(listModel.get(0).getNome());
            vo.setTelefone(listModel.get(0).getTelefone());
        } else {
            throw new ValidationException(REGISTRO_NAO_ENCONTRADO);
        }

        return vo;

    }

    public ContatoMedicoModel editar(Long id,ContatoMedicoDto dto) {

        ContatoMedicoModel model = new ContatoMedicoModel();

        if (id != null) {

            model = this._contatoMedicoRepository.findById(id).orElse(criar(dto));

            model.setNome(dto.getNome());
            model.setEmail(dto.getEmail());
            model.setStatus(dto.isStatus());
            model.setTelefone(dto.getTelefone());
            model.setUpdateDate(LocalDateTime.now());

            model = this._contatoMedicoRepository.save(model);

        } else {
            model = criar(dto);
        }

        return model;
    }

    public ContatoMedicoModel criar(ContatoMedicoDto dto) {

        ContatoMedicoModel model = new ContatoMedicoModel();


            model.setNome(dto.getNome());
            model.setEmail(dto.getEmail());
            model.setStatus(dto.isStatus());
            model.setTelefone(dto.getTelefone());
            model.setCreateDate(LocalDateTime.now());
            model.setUpdateDate(LocalDateTime.now());

            model = this._contatoMedicoRepository.save(model);

            return model;
    }
}
