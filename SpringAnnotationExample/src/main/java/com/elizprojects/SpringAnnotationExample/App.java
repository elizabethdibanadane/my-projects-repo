package com.elizprojects.SpringAnnotationExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext myApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
        Samsung myS7 = myApplicationContext.getBean(Samsung.class);
        myS7.config();
    }
}
