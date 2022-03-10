package aop11;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
	
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aop11.xml");
		
		사람 alice = ctx.getBean("alice", 사람.class);
		사람 bob = ctx.getBean("bob", 사람.class);
		
		int usedTime1 = 0;
		try {
			usedTime1 = alice.usingComputer("1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("앨리스 사용시간 : " + usedTime1);
		System.out.println("==========================");
	
		int usedTime2 = 0;
		try {
			usedTime2 = bob.usingComputer("5678");
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("밥 사용시간 : " + usedTime2);
	}
}
