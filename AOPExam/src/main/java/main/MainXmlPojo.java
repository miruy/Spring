package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap06.Calculator;
import chap06.ImplCalculator;

public class MainXmlPojo {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopPojo.xml");
		
		Calculator implCal = ctx.getBean("implCal", Calculator.class);
		//ImplCalculrator implCal = ctx.getBean("implCal", ImplCalculrator.class);
		//ImplCalculrator는 Calculator를 상속받고 있으므로 Proxy는 상속받은 부모클래스의 객체를 생성한다.
		//따라서 자식객체가 아닌 부모객체를 생성해야한다. 
		long fiveFact1 = implCal.factorial(5);
		System.out.println("implCal.factorial(5) = " + fiveFact1);
		
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		//RecCalculrator recCal = ctx.getBean("recCal", RecCalculrator.class);
		long fiveFact2 = recCal.factorial(5);
		System.out.println("recCal.factorial(5) = " + fiveFact2);
		
		ctx.close();
	}

}
