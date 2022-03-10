package exam06;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

//자바버전(메서드 순서주기)
//<!--
//	 한곳에 공통기능이 동일하게 적용되야 한다면 order를 조작해야하므로 order태그 작성함 
//	timeCalc (Before): 우선순위 낮음 0,1,2..
//	cacheAspect (After): 우선순위 높음 ..2.1,0
//	따라서, 메서드들을 다 사용할 건데 그 중에서도 먼저 실행하고자 하는 메서드에게 높은(먼저) 순서를 주면 됨 
//	-->

@Aspect
@Order(1)
public class CacheAspect {
	private Map<Long, Object> cache = new HashMap<>();
	
	@Around("execution(* factorial(..))")
	public Object caching(ProceedingJoinPoint pjp) throws Throwable{
		Long n = Long.valueOf(pjp.getArgs()[0].toString());
		if(cache.containsKey(n)) {
			System.out.println("[" + n + "]Cache에서 구함");
			return cache.get(n);
		}
		Object result = pjp.proceed();
		cache.put(n, result);
		System.out.println("[" + n + "]Cache에 추가함");
		return result;
	}
}
