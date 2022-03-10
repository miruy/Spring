package chap06;

//재귀호출을 이용하여 팩토리얼을 구하는 클래스
public class RecCalculator implements Calculator{
	
	//재귀호출 :  함수 내부에서 함수가 자기 자신을 또다시 호출하는 행위
	//따라서. 재귀 호출은 자기가 자신을 계속해서 호출하므로, 끝없이 반복됨
	 
	public long factorial(long num) {
		
		if(num == 0) {
			return 1;
		}else {
			return num * factorial(num - 1);
		}
	}
}
