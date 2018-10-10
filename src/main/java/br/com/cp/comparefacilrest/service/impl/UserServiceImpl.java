package br.com.cp.comparefacilrest.service.impl;
import br.com.cp.comparefacilrest.model.User;
import br.com.cp.comparefacilrest.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Service Implementation for managing .
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        log.debug("Request to save UserServiceImpl : {}", user);
        return userRepository.save(user);
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        log.debug("Request to get all Usuario");

        return userRepository.findAll();
    }

  
}
