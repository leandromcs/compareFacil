package br.com.cp.comparefacilrest.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cp.comparefacilrest.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{
	


	List<User> findAll();

}
