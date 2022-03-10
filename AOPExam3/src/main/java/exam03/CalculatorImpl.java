package exam03;

//반복문으로 팩토리얼을 구하는 기능
public class CalculatorImpl implements Calculator{

	@Override
	public long factorial(int n) {
		long result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

}
