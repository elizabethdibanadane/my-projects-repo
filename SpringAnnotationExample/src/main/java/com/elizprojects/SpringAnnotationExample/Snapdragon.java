package com.elizprojects.SpringAnnotationExample;

import org.springframework.stereotype.Component;

@Component
public class Snapdragon implements PhoneProcessor {

	public void process() {
		System.out.println("Primary processor");

	}

}
