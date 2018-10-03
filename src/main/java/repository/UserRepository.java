package repository;

import org.springframework.data.repository.CrudRepository;

import model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByName(String nome);

}
