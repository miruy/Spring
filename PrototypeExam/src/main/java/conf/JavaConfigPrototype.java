package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client2;


//기본적으로 스프링 컨테이너는 싱글톤을 적용하여 객체를 생성함(객체는 하나만 만들고 여러개의 변수가 참조하는)
//그러나 여러개의 객체가 생성되어야 하는 경우 
//<bean>태그 안에 scope="prototype"을 작성하여 getBean이 호출될 때 마다
//객체가 생성되게 할 수 있음 (단, 자동소멸 되지 않으므로 객체 소멸은 직접 처리해야함)
@Configuration
public class JavaConfigPrototype {	
	
	@Bean	//객체 생성 
	@Scope("prototype")	//객체 생성 시 여려개의 객체 생성을 요청 
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("서버2");
		return client2;
	}
}
