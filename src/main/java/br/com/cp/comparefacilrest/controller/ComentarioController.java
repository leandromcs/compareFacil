package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.dto.ComentarioDTO;
import br.com.cp.comparefacilrest.exception.NegocioException;
import br.com.cp.comparefacilrest.model.Comentario;
import br.com.cp.comparefacilrest.service.impl.ComentarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioServiceImpl comentarioService;

    @PostMapping
    public ResponseEntity<Comentario> create(@RequestBody ComentarioDTO dto) {
        Comentario comentario = null;
        try {
            comentario = comentarioService.save(dto);
        } catch (NegocioException e) {
            e.getMessage();
        }
        return new ResponseEntity<>(comentario, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> getAll() {
        List<Comentario> comentarios = null;
        try {
            comentarios = comentarioService.getAll();
        } catch (NegocioException e) {
            e.getMessage();
        }
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteComentario(@PathVariable Long id) {
        try {
            comentarioService.delete(id);
        } catch (NegocioException e) {
            e.getMessage();
        }
        return new ResponseEntity<>("Comentario com sucesso", HttpStatus.OK);
    }

}