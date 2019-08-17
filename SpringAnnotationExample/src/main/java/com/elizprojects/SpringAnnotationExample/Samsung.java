package com.elizprojects.SpringAnnotationExample;

import org.springframework.beans.factory.annotation.Autowired;

public class Samsung {

	@Autowired
	PhoneProcessor myProcessor;
	
	
	public PhoneProcessor getMyProcessor() {
		return myProcessor;
	}


	public void setMyProcessor(PhoneProcessor myProcessor) {
		this.myProcessor = myProcessor;
	}


	public void config() {
		System.out.println("Octa Core, 4GB RAM, 12MP Cam");
		myProcessor.process();
	}
}
