package br.com.cp.comparefacilrest.controller;

import br.com.cp.comparefacilrest.model.User;
import br.com.cp.comparefacilrest.repository.UserRepository;
import br.com.cp.comparefacilrest.service.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;


@RestController()
@RequestMapping("/api")
public class UserController {
	
private UserRepository userRepository;
private UserService userService;

    /**
     * This method does create user.
     * @Param User
     * @return object User and status OK(200)
     * **/

    @PostMapping(value="/users")
    public ResponseEntity<User> create(User user) throws URISyntaxException{
        user = new User();
        user.setId(12);
        user.setNome("Paulo");

        /**
         * Antes de começar retirar,certifique se o MySQL está de pé.Retirar os comentários e substituir o return que está comentado pelo que não está.
         * **/
          // User result = userService.save(user);
           //return ResponseEntity.created(new URI("/users" + result.getId())).body(result);

        return ResponseEntity.ok().body(user);
    }



}