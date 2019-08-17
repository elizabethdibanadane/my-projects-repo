package com.elizprojects.SpringPractise;

import org.springframework.stereotype.Component;

@Component
public class Jeep implements Vehicle{

	public void drive() {
		System.out.println("Drives Jeep");
	}
}
