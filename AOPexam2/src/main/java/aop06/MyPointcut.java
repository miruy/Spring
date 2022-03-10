package aop06;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {

	@Pointcut("execution(* usingComputer(..))")
	public void myPointcut() {}	//함수이름을 포인트컷 id 역할로 사용  
}
