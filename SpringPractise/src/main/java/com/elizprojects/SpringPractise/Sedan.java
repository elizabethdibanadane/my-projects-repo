package com.elizprojects.SpringPractise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sedan implements Vehicle{

	@Autowired
	private Tyre myTyre;
	
	public Tyre getMyTyre() {
		return myTyre;
	}

	public void setMyTyre(Tyre myTyre) {
		this.myTyre = myTyre;
	}

	public void drive() {
		System.out.println("Drives Sedan" + myTyre);
	}
}
