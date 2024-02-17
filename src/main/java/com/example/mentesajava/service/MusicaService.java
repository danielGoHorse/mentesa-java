package com.example.mentesajava.service;

import com.example.mentesajava.dto.HumorHistoricoDto;
import com.example.mentesajava.dto.MusicaDto;
import com.example.mentesajava.model.HumorHistoricoModel;
import com.example.mentesajava.model.MusicaModel;
import com.example.mentesajava.repository.MusicaRepository;
import com.example.mentesajava.vo.MusicaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicaService {

    @Autowired private MusicaRepository _musicaRepository;
    public List<MusicaVO> consultaMusica() {


        List<MusicaModel> listModel = this._musicaRepository.consultaMusica();

        List listVo = new ArrayList<>();
        if (!listModel.isEmpty()){
            MusicaVO musicaVo = new MusicaVO();
            for (int i = 0; i < listModel.size(); i++) {
                musicaVo.setNomeMusica(listModel.get(i).getNomeMusica());
                musicaVo.setLink(listModel.get(i).getLink());
            }
            listVo.add(musicaVo);

        }

        return listVo;

    }

    public MusicaModel salvar(MusicaDto dto) {

        MusicaModel model = new MusicaModel();

        model.setNomeMusica(dto.getNomeMusica());
        model.setLink(dto.getLink());

        model = this._musicaRepository.save(model);

        return model;
    }
}
