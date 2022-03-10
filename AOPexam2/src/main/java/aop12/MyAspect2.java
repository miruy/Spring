package aop12;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAspect2 {

	@After("execution(* usingComputer(..))")	
	public void shutdownComp(JoinPoint jp) {
		String comp = jp.getTarget().getClass().getSimpleName(); //정보를 알아오는 메서드 
		System.out.println(comp + " 시스템 종료");
	}
}
