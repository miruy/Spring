package exam02;

//재귀로 팩토리얼을 구하는 기능
public class CalculatorRecu implements Calculator{
	//시간 구하는 코드 없음 
	@Override
	public long factorial(int n) {
		if(n == 0) {
			return 1;
		}else {
			return n * factorial(n-1);
		}
	}

}
