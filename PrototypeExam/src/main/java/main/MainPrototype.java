package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import conf.JavaConfigPrototype;
import spring.Client;
import spring.Client2;

public class MainPrototype {

	public static void main(String[] args) {

		useXml(); // 메인메서드 안에 xml설정파일을 사용하는 메서드 호출
		useJava(); // 메인메서드 안에 java설정파일을 사용하는 메서드 호출

	} // 메인메서드 끝

	public static void useXml() {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:springConfPrototype.xml");
		
		Client client1 = ctx.getBean("client", Client.class);
		Client client2 = ctx.getBean("client", Client.class);
		
		System.out.println(
				"xml 설정 prototype : (client1 != client2) -> " + (client1 != client2));
		
		ctx.close();
	}

	public static void useJava() {
		AbstractApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
		
		Client2 client1 = ctx.getBean("client2", Client2.class);
		Client2 client2 = ctx.getBean("client2", Client2.class);
		
		System.out.println(
				"java 설정 prototype : (client1 != client2) -> " + (client1 != client2));
		
		ctx.close();
	}

}
