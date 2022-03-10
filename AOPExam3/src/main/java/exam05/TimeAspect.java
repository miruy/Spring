package exam05;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeAspect {
	
	public Object timeCalc(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.nanoTime();
		Object result = pjp.proceed();
		long end = System.nanoTime();
		System.out.printf("%s(%d) => %d[%d]\n", 
				pjp.getTarget().getClass().getSimpleName(),
				pjp.getArgs()[0],
				result,
				end - start);
		return result;
	}
}
