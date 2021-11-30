package gusi.springframework.springdata.controller.dto;

public class TokenDto {

	private String token;
	private String type;
	private Long userId;

	public TokenDto(String token, String type ) {
		this.token = token;
		this.type = type;
		
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	
	
}
