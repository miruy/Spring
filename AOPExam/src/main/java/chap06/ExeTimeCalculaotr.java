package chap06;

//코드를 수정하지 않으면서 코드 중복을 하지 않는 방법 - 프록시 객체 
//프록시 객체 클래스 
public class ExeTimeCalculaotr implements Calculator{
	
	private Calculator delegate;	//대리자
	
	public ExeTimeCalculaotr(Calculator delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public long factorial(long num) {
		
		long start = System.nanoTime();
		long result = delegate.factorial(num);	//팩토리얼의 결과
		long end = System.nanoTime();
		
		System.out.printf("%s.factorial(%d) 수행시간 : %d\n",
								delegate.getClass().getSimpleName(),
									num, (end - start));
		
		return result;
	}
}
