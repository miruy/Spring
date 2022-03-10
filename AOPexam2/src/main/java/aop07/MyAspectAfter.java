package aop07;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

//횡단 관심사 정의 클래스(어노테이션 적용)
public class MyAspectAfter {

	public void shutdownComp(JoinPoint jp) {
		String comp = jp.getTarget().getClass().getSimpleName(); //정보를 알아오는 메서드 
		System.out.println(comp + " 시스템 종료");
	}
}
