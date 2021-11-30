package gusi.springframework.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusi.springframework.springdata.controller.dto.UserDto;
import gusi.springframework.springdata.model.User;
import gusi.springframework.springdata.repository.UserRepository;

@RestController
@EnableScheduling
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@GetMapping
	public List<UserDto> listUsers() {
		List<User> users = userRepository.findAll();
		return UserDto.converter(users);
	}

	@PostMapping
	public ResponseEntity<String> saveUser(@RequestBody User user) {

		try {
			user.setPassword(encoder.encode(user.getPassword()));
			userRepository.save(user);
			return ResponseEntity.ok().body("Usuário Cadastrado");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO - Não cadastrado");
		}

	}

}
