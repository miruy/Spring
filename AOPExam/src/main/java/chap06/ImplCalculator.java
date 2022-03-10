package chap06;

//Calculator인터페이스를 구현하여 for문을 이용해 팩토리얼을 구하는 클래스 
public class ImplCalculator implements Calculator{
	
	@Override
	public long factorial(long num) {
		long result = 1;
		
		for(int i = 0; i <= num; i++) {
			result *= 1;
		}
		return result;
	}
}
