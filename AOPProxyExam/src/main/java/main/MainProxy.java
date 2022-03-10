package main;

import chap06.ExeTimeCalculaotr;
import chap06.ImplCalculator;
import chap06.RecCalculator;

public class MainProxy {

	public static void main(String[] args) {
		
		ExeTimeCalculaotr ttCal1 = new ExeTimeCalculaotr(new ImplCalculator());
		System.out.println(ttCal1.factorial(20));
		
		ExeTimeCalculaotr ttCal2 = new ExeTimeCalculaotr(new RecCalculator());
		System.out.println(ttCal2.factorial(20));

	}
	
	/* 
	 * 해당 프로젝트의 실행을 예시로 
	 * 실행시간을 구하는 클래스처럼 핵심기능이 아닌 부가기능 클래스를 프록시객채 또는 데코레이터 객체라고 하며,
	 * 팩토리얼을 구하는 클래스 처럼 핵심기능을 수행하는 클래스를 대상객체라고 함 
	 * 
	 * AOP란
	 * 핵심기능과 부가기능을 분류하여 핵심기능이 동작할 때 어느 시점에 어떤 부가기능을
	 * 쉽게 삽입할 수 있도록 방법을 제공하는 개발 방법론
	 * */

}
