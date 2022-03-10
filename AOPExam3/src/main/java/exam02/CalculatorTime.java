package exam02;

public class CalculatorTime implements Calculator{

	private Calculator delegate;	//Calculator참조한다는 뜻의 변수
	
	public CalculatorTime(Calculator delegate) {
		this.delegate = delegate;	//대리자를 선언
	}
	
	@Override
	public long factorial(int n) {
		long start = System.nanoTime();	//= @Before의 개념 
		long result = delegate.factorial(n); //pjp.proceed();(=걸린시간, 공통기능, 핵심기능 동작)
		//특정메서드가 실행 되기 전/ 후에 무엇을 실행시켜라
		
		long end = System.nanoTime();	//= @After의 개념
		System.out.printf("%s(%d) => %d[%d]\n", 
				delegate.getClass().getName(),
				n,
				result,
				end - start);
		return result;
	}

}
