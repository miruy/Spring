package aop10;

import org.aspectj.lang.ProceedingJoinPoint;

//횡단 관심사 정의 클래스
public class MyAspect {
	
	
	public Object play(ProceedingJoinPoint pjp) {
		String comp = pjp.getTarget().getClass().getSimpleName();
		String pwd = (String)pjp.getArgs()[0];
		
		
		//before 
		System.out.println("컴퓨터 부팅 및 " + pwd + "를 입력하여 로그인");
		
		Object result = null;
		
		try {
			result = pjp.proceed();	//usingComputer()호출
			//after-returining 
			System.out.println(comp +"작업종료");
		}catch(Throwable e) {
			e.printStackTrace();
			//after-throwing
			System.out.println(comp +"예외발생");
		}
		
		//after
		System.out.println(comp + " 시스템 종료");
		
		return result;
		
		
	}
}
