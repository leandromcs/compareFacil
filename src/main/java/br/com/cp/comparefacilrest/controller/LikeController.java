package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.dto.LikeDTO;
import br.com.cp.comparefacilrest.model.Like;
import br.com.cp.comparefacilrest.service.impl.LikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Like>> findAll() {
        List<Like> likes = likeService.findAll();
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }
}
