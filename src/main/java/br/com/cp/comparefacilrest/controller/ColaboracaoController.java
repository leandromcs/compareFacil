package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.dto.ColaboracaoDTO;
import br.com.cp.comparefacilrest.exception.NegocioException;
import br.com.cp.comparefacilrest.model.Colaboracao;
import br.com.cp.comparefacilrest.service.impl.ColaboracaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboracao")
public class ColaboracaoController {

    @Autowired
    private ColaboracaoServiceImpl colaboracaoService;

    @PostMapping
    public ResponseEntity<Colaboracao> create(@RequestBody ColaboracaoDTO dto) {
        Colaboracao colaboracao = null;
        try {
            colaboracao = colaboracaoService.save(dto);
        } catch (NegocioException e) {
            e.getMessage();
        }
        return new ResponseEntity<>(colaboracao, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Colaboracao>> getAll() {
        List<Colaboracao> colaboracoes = null;
        try {
            colaboracoes = colaboracaoService.getAll();
        } catch (NegocioException e) {
            e.getMessage();
        }
        return new ResponseEntity<>(colaboracoes, HttpStatus.OK);
    }

    @GetMapping("/aprovados")
    public ResponseEntity<List<Colaboracao>> getColaboracaosAtivas() {
        List<Colaboracao> colaboracoes = colaboracaoService.getColaboracoesAprovadas();

        return new ResponseEntity<>(colaboracoes, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateColaboracao(@RequestBody ColaboracaoDTO dto) {
        Colaboracao colaboracao = null;
        try {
            colaboracao = colaboracaoService.atualizarColaboracao(dto);
        } catch (NegocioException e) {
            e.getMessage();
        }
            return new ResponseEntity<>(colaboracao, HttpStatus.OK);
    }

    @PutMapping(value = "/delete/{id}")
    public ResponseEntity deleteColaboracao(@PathVariable Long id) {
        try {
            colaboracaoService.delete(id);
        } catch (NegocioException e) {
            e.getMessage();
        }
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }

}