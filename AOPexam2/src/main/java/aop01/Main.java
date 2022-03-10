package aop01;

public class Main {
	public static void main(String[] args) {
		프로게이머 alice = new 프로게이머();
		프로그래머 bob = new 프로그래머();
		
		int usedTime1 = alice.usingComputer("1234");
		System.out.println("앨리스 사용시간 : " + usedTime1);
		System.out.println("==========================");
		
		int usedTime2 = bob.usingComputer("5678");
		System.out.println("밥 사용시간 : " + usedTime2);
	}
}
