package com.itz.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
class PingController{
	@GetMapping("/ping")
	public ResponseEntity<?> pingTest(){
		Map<String,Object> statusOb = new HashMap<>();
		statusOb.put("ping",1);
		return new ResponseEntity<>(statusOb, HttpStatus.OK);
	}
}

@RestController
@RequestMapping("/api")
class LoginCheck{
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ResponseEntity<?> loginCheckMethod(@RequestBody LoginDao loginDao){
		if(loginDao.getUsername().equals("admin") && loginDao.getPassword().equals("admin")){
			return new ResponseEntity<>("1",HttpStatus.OK);
		}
		return new ResponseEntity<>("-1", HttpStatus.BAD_REQUEST);
	}
}