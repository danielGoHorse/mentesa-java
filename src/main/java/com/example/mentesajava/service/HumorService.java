package com.example.mentesajava.service;

import com.example.mentesajava.model.HumorModel;
import com.example.mentesajava.model.UsuarioModel;
import com.example.mentesajava.repository.HumorRepository;
import com.example.mentesajava.repository.UsuarioRepository;
import com.example.mentesajava.vo.HumorVO;
import com.example.mentesajava.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumorService {

//    private static final String REGISTRO_CADASTRADO = "Contato Principal já cadastrado!";
    private static final String REGISTRO_NAO_ENCONTRADO = "Registro não encontrado!";

    @Autowired
    private HumorRepository _humorRepository;


    public HumorVO retornaHumor() {

        List<HumorModel> listModel = this._humorRepository.consultaHumor();

        HumorVO vo = new HumorVO();
        if (!listModel.isEmpty()){
            vo.setId(listModel.get(0).getId());
//            vo.setStatus(listModel.get(0).getCreateDate());
        }

        return vo;

    }
}
