package com.elizprojects.SpringPractise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Sedan mySedan = new Sedan();
        //mySedan.drive();
        
        //Jeep myJeep = new Jeep();
        //myJeep.drive();
    	
    	//BeanFactory - for small apps
    	//ApplicationContxt - for eterprise level or web apps
    	
    	ApplicationContext myApplicationContext = new ClassPathXmlApplicationContext("contextdef.xml");
    	
    	
    	//Vehicle myAvailableVehicle = (Vehicle)myApplicationContext.getBean("jeep");
    	//myAvailableVehicle.drive();
    	
    	//Tyre myTyre = (Tyre) myApplicationContext.getBean("tyre");
    	//System.out.println(myTyre);
    	
    	Sedan mySedan = (Sedan) myApplicationContext.getBean("sedan");
    	mySedan.drive();
    }
}
