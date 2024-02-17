package com.example.mentesajava.service;

import com.example.mentesajava.dto.HumorHistoricoDto;
import com.example.mentesajava.model.HumorHistoricoModel;
import com.example.mentesajava.repository.HumorHistoricoRepository;
import com.example.mentesajava.vo.HumorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumorService {

//    private static final String REGISTRO_CADASTRADO = "Contato Principal já cadastrado!";
    private static final String REGISTRO_NAO_ENCONTRADO = "Registro não encontrado!";

    @Autowired
    private HumorHistoricoRepository _humorRepository;



    public List<HumorVO> consultaHumorHistorico() {

        List<HumorHistoricoModel> listModel = this._humorRepository.consultaHumorHistorico();

        List humorListVo = new ArrayList<>();
        if (!listModel.isEmpty()){
            HumorVO humorVo = new HumorVO();
            for (int i = 0; i < listModel.size(); i++) {
                humorVo.setId(listModel.get(i).getId());
            }
            humorListVo.add(humorVo);

        }

        return humorListVo;

    }

    public HumorHistoricoModel salvar(HumorHistoricoDto dto) {

        HumorHistoricoModel model = new HumorHistoricoModel();

        model.setHumor(dto.getHumor());
        model.setMensagem(dto.getMensagem());

        model = this._humorRepository.save(model);

        return model;
    }
}
