package gusi.springframework.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusi.springframework.springdata.controller.dto.TokenDto;
import gusi.springframework.springdata.form.LoginForm;
import gusi.springframework.springdata.secutiry.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<TokenDto> authentication(@RequestBody LoginForm form) { 
		
		UsernamePasswordAuthenticationToken loginData = form.convert(); 
		
		try {
			Authentication authentication =  authManager.authenticate(loginData);
			String token = tokenService.generateToken(authentication);			
			
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
