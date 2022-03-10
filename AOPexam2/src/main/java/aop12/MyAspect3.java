package aop12;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAspect3 {
	
	//After-Returning(정상적으로 종료되었을 경우 표현)
	@AfterReturning("execution(* usingComputer(..))")
	public void Finished(JoinPoint jp) {
		String comp = jp.getTarget().getClass().getSimpleName();
		System.out.println(comp + " 작업종료");
	}
}
