package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import conf.JavaConfigPrototype;
import spring.Client;
import spring.Client2;

//scope="prototype"은 객체가 자동소멸 되지 않으므로 직접 소멸처리 해주어야함 
//객체 소멸처리를 적용한 클래스
public class MainPrototype2 {

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
		
		//try-catch문안에 소멸메서드 호출하기
		try {
			client1.destroy();
			client2.destroy();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ctx.close();
	}

	public static void useJava() {
		AbstractApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
		
		Client2 client1 = ctx.getBean("client2", Client2.class);
		Client2 client2 = ctx.getBean("client2", Client2.class);
		
		System.out.println(
				"java 설정 prototype : (client1 != client2) -> " + (client1 != client2));
		
		//try-catch문안에 소멸메서드 호출하기
		try {
			client1.close();
			client2.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ctx.close();
	}

}
