package exam01;

//재귀호출로 팩토리얼을 구하는 기능
public class CalculatorRecu implements Calculator{

	@Override
	public long factorial(int n) {
		if(n == 0) {
			return 1;
		}else {
			return n * factorial(n-1);
		}
	}

}
