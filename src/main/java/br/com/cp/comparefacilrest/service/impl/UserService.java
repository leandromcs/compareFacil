package br.com.cp.comparefacilrest.service.impl;

import br.com.cp.comparefacilrest.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {


    User save(User nome);


    List<User> findAll();

}




