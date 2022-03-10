package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client3;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:springConf.xml");
		
		Client3 client2 = ctx.getBean("client2", Client3.class);
		client2.send();
		ctx.close();
	}

}
