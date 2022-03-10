package aop12;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAspect4 {
	
	//After-Throwing(종료 시 예외가 발생했을 경우 표현)
	@AfterThrowing("execution(* usingComputer(..))")
	public void throwExcept() {
		System.out.println("예외발생");
	}
}
