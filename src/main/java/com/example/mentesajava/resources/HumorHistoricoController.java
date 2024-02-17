package com.example.mentesajava.resources;

import com.example.mentesajava.dto.HumorHistoricoDto;
import com.example.mentesajava.repository.HumorHistoricoRepository;
import com.example.mentesajava.service.HumorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/humor_historico")
public class HumorHistoricoController {

    @Autowired
    private HumorService _humorService;

    @GetMapping("/consultaHumorHistorico")
    public ResponseEntity retornaHumorHistorico() throws Exception{
        try {
            return new ResponseEntity(this._humorService.consultaHumorHistorico(), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody HumorHistoricoDto dto) throws Exception{
        try {
            return new ResponseEntity(this._humorService.salvar(dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
