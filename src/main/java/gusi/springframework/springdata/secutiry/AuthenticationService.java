package gusi.springframework.springdata.secutiry;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gusi.springframework.springdata.model.User;
import gusi.springframework.springdata.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService{

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User>user =  userRepository.findByUser(username);
		if(user.isPresent()) { 
			return user.get();
		}
		throw new UsernameNotFoundException("Dados inválidos.");
	}

	
}
