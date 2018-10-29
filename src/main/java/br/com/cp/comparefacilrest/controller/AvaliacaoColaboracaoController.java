package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.dto.AvaliacaoColaboracaoDTO;
import br.com.cp.comparefacilrest.exception.NegocioException;
import br.com.cp.comparefacilrest.model.AvaliacaoColaboracao;
import br.com.cp.comparefacilrest.service.impl.AvaliacaoColaboracaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao-colaboracao")
public class AvaliacaoColaboracaoController {

    @Autowired
    private AvaliacaoColaboracaoServiceImpl avaliacaoColaboracaoService;

    @PostMapping
    public ResponseEntity<AvaliacaoColaboracao> create(@RequestBody AvaliacaoColaboracaoDTO dto) {
        AvaliacaoColaboracao avaliacaoColaboracao = null;
        try {
            avaliacaoColaboracao = avaliacaoColaboracaoService.save(dto);
        } catch (NegocioException e) {
            e.getMessage();
        }
        return new ResponseEntity<>(avaliacaoColaboracao, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoColaboracao>> getAll() {
        List<AvaliacaoColaboracao> colaboracoes = null;
        try {
            colaboracoes = avaliacaoColaboracaoService.getAll();
        } catch (NegocioException e) {
            e.getMessage();
        }
        return new ResponseEntity<>(colaboracoes, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateAvaliacaoColaboracao(@RequestBody AvaliacaoColaboracaoDTO dto) {
        AvaliacaoColaboracao avaliacaoColaboracao = null;
        try {
            avaliacaoColaboracao = avaliacaoColaboracaoService.atualizarAvaliacaoColaboracao(dto);
        } catch (NegocioException e) {
            e.getMessage();
        }
            return new ResponseEntity<>(avaliacaoColaboracao, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteAvaliacaoColaboracao(@PathVariable Long id) {
        try {
            avaliacaoColaboracaoService.delete(id);
        } catch (NegocioException e) {
            e.getMessage();
        }
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }

}