package br.com.cp.comparefacilrest.service.impl;
import br.com.cp.comparefacilrest.dto.UserDTO;
import br.com.cp.comparefacilrest.model.User;
import br.com.cp.comparefacilrest.repository.UserRepository;
import br.com.cp.comparefacilrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User save(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setNome(dto.getNome());

        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User update(UserDTO dto) {
        Optional<User> consultado = this.userRepository.findById(dto.getId());
        User user = consultado.get();

        user.setId(dto.getId());
        user.setNome(dto.getNome());

        return userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete (Long id) {
        Optional<User> consultado = this.userRepository.findById(id);
        User user = consultado.get();
        userRepository.delete(user);
    }

  
}
