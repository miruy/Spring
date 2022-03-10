package springexam00;

public class Greeter {
	private String name;
	
	public Greeter() {
		System.out.println("Greeter 생성");
	}
	
	public Greeter(String name) {
		System.out.println("Greeter(name) 메서드 생성");
		this.name = name;
	}
	
	public void setName(String name) {
		System.out.println("setName(name) 세팅");
		this.name = name;
	}

	public String getName() {
		System.out.println("getName(name) 반환");
		return name;
	}
	
	
}
