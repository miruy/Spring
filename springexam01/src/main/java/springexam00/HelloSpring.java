package springexam00;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");
		//IOC/DI
		
		Greeter g1 = ctx.getBean("g1", Greeter.class);
		g1.setName("홍길동");
		System.out.println(g1.getName());
		
		
		Greeter g2 = ctx.getBean("g2", Greeter.class);
		System.out.println(g2.getName());
		
		Greeter g3 = ctx.getBean("g3", Greeter.class);
		System.out.println(g3.getName());
		ctx.close();
	}
}
