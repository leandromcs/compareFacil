package br.com.cp.comparefacilrest.service;

import br.com.cp.comparefacilrest.dto.UserDTO;
import br.com.cp.comparefacilrest.model.User;

import java.util.List;

public interface UserService {

    User save(UserDTO dto);

    List<User> findAll();

    User update(UserDTO dto);

    void delete (Long id);
}




