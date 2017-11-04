package net.rwa.springboot.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import net.rwa.springboot.config.JPAConfig;

@Import(JPAConfig.class)
@SpringBootApplication//(exclude = { DataSourceAutoConfiguration.class})
@ComponentScan(basePackages="net.rwa.springboot")
public class SpringbootRestApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringbootRestApplication.class);
	
	public static void main(String[] args) {//throws Throwable  {
		SpringApplication.run(SpringbootRestApplication.class, args);
	}
}
