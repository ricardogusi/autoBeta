package gusi.springframework.springdata.secutiry;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import gusi.springframework.springdata.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${auto.jwt.expiration}")
	private String expiration;
	
	@Value("${auto.jwt.secret}")
	private String secret;

	public String generateToken(Authentication authentication) {
		
		User logged = (User) authentication.getPrincipal();
		Date today = new Date(); 
		Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API auto")
				.setSubject(logged.getId().toString())
				.setIssuedAt(today)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValid(String token) {
		
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {

			return false;
		}
		
	}

	public Long getUserId(String token) {

		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(body.getSubject());
		
		
	}

	
}
