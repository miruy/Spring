package exam03;

import org.aspectj.lang.ProceedingJoinPoint;

//Aspect 클래스 (어디에도 종속되지 않았기 때문에 결합도가 낮음)
public class TimeAspect {
	
	public Object timeCalc(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.nanoTime();	// = @Before
		Object result = pjp.proceed();	//exam02의 메인메서드에서 실행코드와 같은 시점
		long end = System.nanoTime();	// = @After
		System.out.printf("%s(%d) => %d[%d]\n", 
				pjp.getTarget().getClass().getSimpleName(),
				pjp.getArgs()[0],
				result,
				end - start);
		return result;
	}
}
