package aop06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//횡단 관심사 정의 클래스
@Aspect
public class MyAspectBefore {
	
	//MyPointcut패키지 안에 myPointcut()메서드를 사용하겠다는 표현 
	@Before("MyPointcut.myPointcut()")
	public void bootingAndLogin(JoinPoint jp) {
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅 및 " + pwd + "를 입력하여 로그인");
	}
}
