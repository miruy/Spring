package exam05;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

//cache기능을 갖는 Aspect클래스
public class CacheAspect {
							//cache : 자주 사용하는 데이터이므로 미리 저장/유지시켜놓는 공간 
	private Map<Long, Object> cache = new HashMap<>();
	
	//팩토리얼의 키값과 밸류값을 저장시켜놓는 코드를 메서드로 만듬 
	//반복문을 이용해서 cache에 추가하고, 재귀호출을 하여 cache에서 가져오는 흐름 
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
