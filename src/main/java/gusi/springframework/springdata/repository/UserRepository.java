package gusi.springframework.springdata.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gusi.springframework.springdata.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

	
	

	Optional<User> findByUser(String user);
	
	

}
