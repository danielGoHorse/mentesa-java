package com.example.mentesajava.resources;

import com.example.mentesajava.dto.UsuarioDto;
import com.example.mentesajava.repository.UsuarioRepository;
import com.example.mentesajava.service.UsuarioService;
import com.example.mentesajava.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService _usuarioService;

    @Autowired
    private UsuarioRepository repository;
//    @GetMapping("/consultaUsuario")
//    public ResponseEntity retornaUsuario() throws Exception{
//        try {
//            return new ResponseEntity(this._usuarioService.retornaUsuario(), HttpStatus.OK);
//        } catch (ValidationException e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {p
//            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/{id_fire}")
    public ResponseEntity<Object> buscarPorIdFire(@PathVariable String id_fire) throws Exception {
        try {
//            return ResponseEntity.ok("deu Ok");
            return new ResponseEntity(this._usuarioService.retornaUsuarioByFire(id_fire), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/criar")
    public ResponseEntity criarUsuario(@RequestBody UsuarioDto dto) throws Exception{
        try {
            return new ResponseEntity(this._usuarioService.criar(dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
