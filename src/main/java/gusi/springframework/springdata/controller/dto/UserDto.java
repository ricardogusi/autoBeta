package gusi.springframework.springdata.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import gusi.springframework.springdata.model.User;

public class UserDto {

	private Long id; 
	private String user;
		
	
	public UserDto(Long id, String user) {
		this.id = id;
		this.user = user;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	} 
	
	public static List<UserDto> converter(List<User> users) {
		return  users.stream().map((User user) -> new UserDto(user.getId(), user.getUser())).collect(Collectors.toList());
	}
}
