package exam02;

//반복문으로 팩토리얼을 구하는 기능
public class CalculatorImpl implements Calculator{
	//시간 구하는 코드 없음 
	@Override
	public long factorial(int n) {
		long result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

}
