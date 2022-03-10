package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//횡단 관심사 정의 클래스(POJO기반)
public class MyAspect2 {
	
	//컴퓨터 종료 메서드 
	public void shutdownComp(JoinPoint jp) {
		String comp = jp.getTarget().getClass().getSimpleName(); //정보를 알아오는 메서드 
		System.out.println(comp + " 시스템 종료");
	}
}
