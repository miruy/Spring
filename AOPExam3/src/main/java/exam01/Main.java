package exam01;

public class Main {
	
	//시간 구하는 기능 자체를 공통기능으로 사용하고자 한 예제
	
	public static void main(String[] args) {
		//인터페이스를 구현한 클래스들이므로 구현받은 인터페이스로 객체 생성 
		Calculator calcImpl = new CalculatorImpl();
		Calculator calcRecu = new CalculatorRecu();
		
		//팩토리얼 동작 시간을 구해야 한다면?
		long start = 0;	//시작시간 
		long end = 0;	//끝시간
		long time = 0;	//진행 시간
		
		start = System.nanoTime();
		long f1 = calcImpl.factorial(5);	//팩토리얼 진행
		end = System.nanoTime();
		time = end - start;	//걸린시간 구하기
		System.out.printf("%s(%d) => %d[%d]\n", 
				calcImpl.getClass().getName(),
				5,
				f1,
				time);
		
		start = System.nanoTime();
		long f2 = calcRecu.factorial(5);//팩토리얼 진행
		end = System.nanoTime();
		time = end - start;//걸린시간 구하기
		System.out.printf("%s(%d) => %d[%d]\n", 
				calcRecu.getClass().getName(),
				5,
				f2,
				time);
		
		
	}
}
