package aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//횡단 관심사 정의 클래스

@Aspect		 
public class MyAspect {
	//Advice  : 메서드
	//@Before 포인트컷 설정 
	//execution(포인트컷 지시자)
	
								//	aop02.패키지 안에 있는 모든 클래스.
	@Before("execution(public int aop02.*.usingComputer(String))")	//pointcut지점/컴퓨터 사용 전에  
	public void bootingAndLogin(JoinPoint jp) {
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅 및 " + pwd + "를 입력하여 로그인");
	}
}
