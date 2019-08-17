package com.elizprojects.SpringAnnotationExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.elizprojects.SpringAnnotationExample")
public class AppConfig {
	
	/*@Bean
	public Samsung getPhone() {
		return new Samsung();
	}

	@Bean
	public PhoneProcessor getProcessor() {
		return new Snapdragon();
	}*/
}

