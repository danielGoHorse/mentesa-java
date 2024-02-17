package com.example.mentesajava.resources;

import com.example.mentesajava.dto.HumorHistoricoDto;
import com.example.mentesajava.dto.MusicaDto;
import com.example.mentesajava.repository.HumorHistoricoRepository;
import com.example.mentesajava.repository.MusicaRepository;
import com.example.mentesajava.service.HumorService;
import com.example.mentesajava.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/musica")
public class MusicaController {

    @Autowired
    private MusicaService _musicaService;

    @GetMapping("/consultaMusica")
    public ResponseEntity consultaMusica() throws Exception{
        try {
            return new ResponseEntity(this._musicaService.consultaMusica(), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody MusicaDto dto) throws Exception{
        try {
            return new ResponseEntity(this._musicaService.salvar(dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
