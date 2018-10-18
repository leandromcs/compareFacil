package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.dto.UserDTO;
import br.com.cp.comparefacilrest.model.User;
import br.com.cp.comparefacilrest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        User user = userService.save(dto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PutMapping(value = "/users")
    public ResponseEntity updateUser(@RequestBody UserDTO dto) {

        if (dto == null) {
            return null;
        }else {
            User user = userService.update(dto);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {

        if (id == null) {
            return null;
        }else {
            userService.delete(id);
            return new ResponseEntity<>("Deletado com sucesso",HttpStatus.OK);
        }
    }






}