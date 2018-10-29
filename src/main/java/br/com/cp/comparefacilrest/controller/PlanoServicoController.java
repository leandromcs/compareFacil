package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.dto.PlanoServicoDTO;
import br.com.cp.comparefacilrest.model.PlanoServico;
import br.com.cp.comparefacilrest.service.PlanoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plano-servico")//http://localhost:8080/api/plano-servico
public class PlanoServicoController {

    @Autowired
    private PlanoServicoService planoServicoService;

    @PostMapping
    public ResponseEntity<PlanoServico> create(@RequestBody PlanoServicoDTO dto) {
        PlanoServico planoservico = planoServicoService.save(dto);
        return new ResponseEntity<>(planoservico, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PlanoServico>> getAll() {
        List<PlanoServico> planoservicos = planoServicoService.findAll();

        return new ResponseEntity<>(planoservicos, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity updatePlanoServico(@RequestBody PlanoServicoDTO dto) {

        if (dto == null) {
            return null;
        }else {
            PlanoServico planoServico = planoServicoService.update(dto);
            return new ResponseEntity<>(planoServico, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deletePlanoServico(@PathVariable Long id) {

        if (id == null) {
            return null;
        }else {
            planoServicoService.delete(id);
            return new ResponseEntity<>("Deletado com sucesso",HttpStatus.OK);
        }
    }

}
