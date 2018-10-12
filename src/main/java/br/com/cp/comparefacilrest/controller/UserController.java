package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.dto.UserDTO;
import br.com.cp.comparefacilrest.model.User;
import br.com.cp.comparefacilrest.service.impl.UserService;
import org.glassfish.jersey.message.internal.HeaderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;

    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO dto) {
        User user = new User();
        user.setNome(dto.getNome());

        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity updateUser(@Valid @RequestBody UserDTO dto, User user) {

        if (dto.getId() == null) {
            return create(dto);
        }else {
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }





}