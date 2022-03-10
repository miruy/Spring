package aop11;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAspect3 {
	
	//정상적으로 작업종료되었을 때 표현하는 메서드 (After-Returning)
	@AfterReturning("execution(* usingComputer(..))")
	public void Finished(JoinPoint jp) {
		String comp = jp.getTarget().getClass().getSimpleName();
		System.out.println(comp + "작업종료");
	}
}
