package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.dto.LikeDTO;
import br.com.cp.comparefacilrest.model.Like;
import br.com.cp.comparefacilrest.model.Pessoa;
import br.com.cp.comparefacilrest.service.impl.LikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;


@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeServiceImpl likeService;


    @PostMapping
    public ResponseEntity<Like> create(@RequestBody LikeDTO dto) {
        Like like = likeService.save(dto);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    @GetMapping("/countLike/{id}")
    public ResponseEntity<Long> countLike(@PathVariable Long id) {
        Long likesLength = likeService.countLike(id);
        return new ResponseEntity<>(likesLength, HttpStatus.OK);
    }

    @GetMapping("/countDeslike/{id}")
    public ResponseEntity<Long> countDeslike(@PathVariable Long id) {
        Long likesLength = likeService.countDeslike(id);
        return new ResponseEntity<>(likesLength, HttpStatus.OK);
    }

    @GetMapping(value = "/likeByPessoa/{idPessoa}/{idColaboracao}")
    public ResponseEntity<Like> findLikeByIdPessoaAndIdColaboracao(@PathVariable Long idPessoa,@PathVariable Long idColaboracao){
        Like like;
         like = likeService.findLikeByIdPessoaAndIdColaboracao(idPessoa,idColaboracao);

        return new ResponseEntity<>(like,HttpStatus.OK);
    }
}
