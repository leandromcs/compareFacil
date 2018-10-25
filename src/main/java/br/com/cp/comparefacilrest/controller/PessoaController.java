package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.dto.PessoaDTO;
import br.com.cp.comparefacilrest.dto.PessoaDTO;
import br.com.cp.comparefacilrest.model.Pessoa;
import br.com.cp.comparefacilrest.model.Pessoa;
import br.com.cp.comparefacilrest.service.PessoaService;
import br.com.cp.comparefacilrest.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody PessoaDTO dto) {
        Pessoa pessoa = pessoaService.save(dto);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        List<Pessoa> pessoas = pessoaService.findAll();

        return new ResponseEntity<>(pessoas, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity updatePessoa(@RequestBody PessoaDTO dto) {

        if (dto == null) {
            return null;
        }else {
            Pessoa pessoa = pessoaService.update(dto);
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/delete/{id}")
    public ResponseEntity deletePessoa(@PathVariable Long id) {

        if (id == null) {
            return null;
        }else {
            pessoaService.delete(id);
            return new ResponseEntity<>("Deletado com sucesso",HttpStatus.OK);
        }
    }

}