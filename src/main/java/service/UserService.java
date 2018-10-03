package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public User consultarUser(String nome) {
		return repository.findByName(nome);
	}

}
