package com.example.mentesajava.resources;

import com.example.mentesajava.dto.ContatoPrincipalDto;
import com.example.mentesajava.repository.ContatoPricipalRepository;
import com.example.mentesajava.service.ContatoPrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/contato_principal")
public class ContatoPrincipalController {

    @Autowired
    private ContatoPrincipalService _contatoPrincipalService;

    @Autowired
    private ContatoPricipalRepository repository;

    @GetMapping("/")
    public ResponseEntity retornaContatoPrincipal() throws Exception{
        try {
            return new ResponseEntity(this._contatoPrincipalService.retornaContatoPrincipal(), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping ("editar/{id}")
    public ResponseEntity editarContatoPrincipal(@RequestBody ContatoPrincipalDto dto) throws Exception{
        try {
            return new ResponseEntity(this._contatoPrincipalService.editar(dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/criar")
    public ResponseEntity criarContatoPrincipal(@RequestBody ContatoPrincipalDto dto) throws Exception{
        try {
            return new ResponseEntity(this._contatoPrincipalService.criar(dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
