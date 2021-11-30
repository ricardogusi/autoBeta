package gusi.springframework.springdata.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import gusi.springframework.springdata.AutoApplication;

@RestController
public class RestartController {


	    
	@PostMapping("/restart")
	    public void restart() {
		AutoApplication.restart();
	    } 
}
