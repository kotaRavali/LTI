package com.javafsd.JWTdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javafsd.JWTdemo.JWT.Util.JWTUtility;
import com.javafsd.JWTdemo.model.JwtRequest;
import com.javafsd.JWTdemo.model.JwtResponse;
import com.javafsd.JWTdemo.service.UserService;


@RestController
public class HomeController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTUtility jwtUtility;
	 
	@GetMapping("/")
	public String home() {
		return "Hey welcome to Java fullstack";
		}
	
	@PostMapping("/authenticate")
	public JwtResponse autenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							jwtRequest.getUserName(),
							jwtRequest.getPassword()
							)
					);
		}catch(BadCredentialsException bce) {
			throw new Exception("INVALID_CREDENTIAL", bce);
		}
		
		final UserDetails userDetails =
				userService.loadUserByUsername(jwtRequest.getUserName());
		
		final String token = 
				jwtUtility.generateToken(userDetails);
				
		return new JwtResponse(token);
		
	}
}
