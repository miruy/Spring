package exam03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:exam03.xml");
		Calculator calcImpl = ctx.getBean("calcImpl", Calculator.class);
		Calculator calcRecu = ctx.getBean("calcRecu", Calculator.class);
		
		//팩토리얼 동작 시간을 구해야 한다면?
		long f1 = calcImpl.factorial(5);
		long f2 = calcRecu.factorial(5);

		System.out.println("f1:" + f1);
		System.out.println("f2:" + f2);
	}
}
