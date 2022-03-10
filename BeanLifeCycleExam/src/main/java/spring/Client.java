package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//InitializingBean, DisposableBean 두 개의 인터페이스를 구현하여(=도구로 사용 : implements) 
//생성 및 소멸의 흐름 이해
public class Client implements InitializingBean, DisposableBean{
	private String host;
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client,setHost() 실행");
	}
	
	@Override 	//initialisingBean인터페이스를 오버라이딩한 메서드
	public void afterPropertiesSet() throws Exception{	//= 초기화 메서드 
		System.out.println("Client.afterpropertiesSet() 실행");
	}	
	
	public void send() {
		System.out.println("Client.send() to" + host);
	}
	
	@Override	//DisposableBean 인터페이스를 오버라이딩한 메서드
	public void destroy() throws Exception {	//= 소멸 메서드 
		System.out.println("Client.destroy() 실행");
	}
	
}
