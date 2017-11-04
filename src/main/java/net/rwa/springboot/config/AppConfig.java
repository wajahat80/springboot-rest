package net.rwa.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.rwa.springboot.service.UserService;
import net.rwa.springboot.service.UserServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public UserService userService(){
		return new UserServiceImpl();
	}
	
}
