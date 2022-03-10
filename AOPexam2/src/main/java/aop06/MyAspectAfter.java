package aop06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

//횡단 관심사 정의 클래스(어노테이션 적용)

@Aspect
public class MyAspectAfter {
	
	//MyPointcut패키지 안에 myPointcut()메서드를 사용하겠다는 표현 
	@After("MyPointcut.myPointcut()")
	public void shutdownComp(JoinPoint jp) {
		String comp = jp.getTarget().getClass().getSimpleName(); //정보를 알아오는 메서드 
		System.out.println(comp + " 시스템 종료");
	}
}
