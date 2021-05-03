package com.itz.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}
@RestController
@RequestMapping("/api")
class pingController{
	@GetMapping("/ping")
	public ResponseEntity<?> pingTest(){
		Map<String,Object> statusOb = new HashMap<>();
		statusOb.put("ping",1);
		return new ResponseEntity<>(statusOb, HttpStatus.OK);
	}
}