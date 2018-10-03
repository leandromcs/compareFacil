package controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;

    @GetMapping("/user")
    public User greeting(@QueryParam(value = "nome") String nome) {
        return service.consultarUser(nome);
    }
}
