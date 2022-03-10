package spring;

//소스코드없이 외부에서 클래스를 제공받아 사용하거나 직접 
//initalizingBean, DisposableBean 인터페이스를 구현하지 못하는 경우
//해당 인터페이스를 대채하여 init-method, destroy-method속성을 사용할 수 있음 
public class Client3 {
	private String host;
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client3.setHost() 실행");
	}
	
	//init()
	public void connect() throws Exception {
		System.out.println("Client3.connect() 실행");
	}
	
	public void send() {
		System.out.println("Client3.send() to" + host);
	}
	
	//destroy()
	public void close() throws Exception {	//= 소멸 메서드 
		System.out.println("Client3.close() 실행");
	}
}
