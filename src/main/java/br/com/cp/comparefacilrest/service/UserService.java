package br.com.cp.comparefacilrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cp.comparefacilrest.model.User;
import br.com.cp.comparefacilrest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public User consultarUser(String nome) {
		return repository.findByName(nome);
	}

}
