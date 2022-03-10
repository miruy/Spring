package exam02;

public class Main {
	public static void main(String[] args) {
								//시간을 구하는 클래스 생성(=프록시 클래스)
								//대리자의 역할 
		Calculator calcImpl = new CalculatorTime(new CalculatorImpl());
		Calculator calcRecu = new CalculatorTime(new CalculatorRecu());
		
		//팩토리얼 동작 시간을 구해야 한다면?
		long f1 = calcImpl.factorial(5);
		long f2 = calcRecu.factorial(5);
		System.out.println("f1:" + f1);
		System.out.println("f2:" + f2);
	}
}
