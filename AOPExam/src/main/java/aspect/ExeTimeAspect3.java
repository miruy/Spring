package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//공통기능을 제공하는 클래스 
//(자바코드에 어노테이션 추가하여 설정햐는 방법 이지만 클래스에 @Configuration선언을 하지 않앗으므로 xml파일에 설정해주어야 함)
//공통기능으로 사용할 클래스라는 선언 
@Aspect	
public class ExeTimeAspect3 {
	
	//Aspect : 공통된 관심사 , 관점
	//여러클래스에서 같은 로직(기능)이 구현될 때 사용됨 
	//공통적인 로직(기능)을 필요로 하는 각 클래승 하나하나 추가 하지 않고 
	//띠로 하나의 클래스로 생성해 사용함 
	//공통 기능을 분리해 놓고 적용하고자 하는 부분에만 proxy라는 객체를 이용하여 적용하는 것이 AOP 기법
	//호출(client) -> Proxy(대행) -> Target(핵심기능)
	
	//chap06 하위 모든 파일에 공통기능을 적용할 것일는 선언
	@Pointcut("execution(public * chap06..*(..))")
	private void publicTarget() {
		
	}
	
	//measure : 측정메서드 
	//joinPoint : Advice(공통적인 기능 그 자체)를 적용하는 부분(필드/메서드등) 
	//Proceed(진행하다)
	//ProceedingJoinPoin 클래스 : 공통기능(Aspect의 Advice)를 실행하는 클래스 
	
	@Around("publicTarget()") //publicTarget() 메서드 실행 전/후에 에외가 발생하면 공통기능을 적용하라는 선언
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
	//위 코드 해석 : 해당 pointcut에 적용할 공통 기능으로 @Around를 적용한 measure()메서드를 사용한다. 
	//즉, chap06패키지 또는 그 하위 패키지에 속한 Bean객체의 public메서드를 실행할 경우 
	//지정된 Around Advice인 measure()메서드가 실행된다.	
		
		long start = System.nanoTime();
		
		try {
			Object result = joinPoint.proceed();	//공통기능이 적용된 부분을 실행 하여 result변수에 담음 
			return result;
		}
		finally {
			long finish = System.nanoTime();
			
			//Signature() : 호출되는 메서드의 대한 정보는 구하는 메서드, 해당 메서드의 반환타입, 이름, 매개변수 등이 담긴 객체를 반환함 
			Signature sig = joinPoint.getSignature();	//공통기능이 적용된 메서드의 정보를 반환하여 sig변수에 담음  
			System.out.printf("%s, %s(%s) 실행시간 : %d ns\n",
					
										//getTarget() : 클라이언트가 비즈니스 메서드를 호출하였을 때 해당 메서드를 가지고 있는 대상객체를 반환함  
								joinPoint.getTarget().getClass().getSimpleName(),	 
								
																		  //getArgs() : 클라이언트가 비즈니스 메서드를 호출할 때 넘겨주는 파라미터 값을 반환함 
									sig.getName(), Arrays.toString(joinPoint.getArgs()),
										(finish - start));
		}
	}
}
