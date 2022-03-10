package exam04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//자바설정으로 변경예제
@Aspect
public class TimeAspect {
	
	@Around("execution(* factorial(..))")
	public Object timeCalc(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.nanoTime();
		Object result = pjp.proceed(); //delegate.factorial(n)
		long end = System.nanoTime();
		System.out.printf("%s(%d) => %d[%d]\n", 
				pjp.getTarget().getClass().getSimpleName(),
				pjp.getArgs()[0],
				result,
				end - start);
		return result;
	}
}
