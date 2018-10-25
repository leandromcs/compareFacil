package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.dto.ProvedoraDTO;
import br.com.cp.comparefacilrest.exception.NegocioException;
import br.com.cp.comparefacilrest.model.Provedora;
import br.com.cp.comparefacilrest.service.impl.ProvedoraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("provedora")
public class ProvedoraController {

    @Autowired
    private ProvedoraServiceImpl service;

    @GetMapping("/provedoras")
    public ResponseEntity<List<Provedora>> findAll(){
        List<Provedora> provedoras = null;
        try {
            provedoras = this.service.getAll();
        } catch (NegocioException e) {
            e.getMessage();
    }
        return new ResponseEntity<>(provedoras, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provedora> findById(@PathVariable Long id){
        Provedora provedora = new Provedora();
        try {
            provedora = this.service.findById(id);
        } catch (NegocioException e) {
            e.getMessage();
        }
        return new ResponseEntity<>(provedora, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Provedora> cadastrarProvedora(@PathVariable ProvedoraDTO dto){
//        Provedora provedora = new Provedora();
//        try {
//            provedora = this.service.save(dto);
//        } catch (NegocioException e) {
//            e.getMessage();
//        }
//        return new ResponseEntity<>(provedora, HttpStatus.OK);
//    }

}
