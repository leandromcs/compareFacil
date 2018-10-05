package br.com.cp.comparefacilrest.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cp.comparefacilrest.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByName(String nome);

}
