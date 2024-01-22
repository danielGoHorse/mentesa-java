package com.example.mentesajava.resources;

import com.example.mentesajava.repository.HumorRepository;
import com.example.mentesajava.repository.UsuarioRepository;
import com.example.mentesajava.service.HumorService;
import com.example.mentesajava.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/humor")
public class HumorController {

    @Autowired
    private HumorService _humorService;

    @Autowired
    private HumorRepository repository;

    @GetMapping("/consultaHumor")
    public ResponseEntity retornaHumor() throws Exception{
        try {
            return new ResponseEntity(this._humorService.retornaHumor(), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
