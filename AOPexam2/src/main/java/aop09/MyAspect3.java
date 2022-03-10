package aop09;

import org.aspectj.lang.JoinPoint;

public class MyAspect3 {
	
	//정상적으로 작업종료되었을 때 표현하는 메서드 (After-Returning에 동작예정)
	
	public void Finished(JoinPoint jp) {
		String comp = jp.getTarget().getClass().getSimpleName();
		System.out.println(comp + "작업종료");
	}
}
