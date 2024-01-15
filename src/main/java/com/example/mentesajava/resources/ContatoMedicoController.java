package com.example.mentesajava.resources;

import com.example.mentesajava.dto.ContatoMedicoDto;
import com.example.mentesajava.service.ContatoMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;


@RestController
@RequestMapping("/contatoMedico")
public class ContatoMedicoController {

    @Autowired
    private ContatoMedicoService _contatoMedicoService;

    @GetMapping("/{id}")
    public ResponseEntity retornaContatoMedico(@PathVariable(value="id") Long id) throws Exception{
        try {
            return ResponseEntity.ok("deu Ok");
            //            return new ResponseEntity(this._contatoMedicoService.retornaContatoPrincipal(id), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping ("/{id}")
    public ResponseEntity editarContatoMedico(@PathVariable(value="id") Long id, @RequestBody ContatoMedicoDto dto ) throws Exception{
        try {
            return new ResponseEntity(this._contatoMedicoService.editar(id, dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity criarContatoMedico(@RequestBody ContatoMedicoDto dto) throws Exception{
        try {
            return new ResponseEntity(this._contatoMedicoService.criar(dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
