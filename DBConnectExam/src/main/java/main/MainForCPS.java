package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberNotFoundException;

//암호변경 기능을 실행하는 클래스
public class MainForCPS {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		//암호변경 객체 생성 
		ChangePasswordService cps = 
				ctx.getBean("changePwdSvc", ChangePasswordService.class);

		try {
			//암호변경 객체로 암호변경 메서드를 호출하여 이메일을 검색하여 
			//회원을 찾은 후 1234를 1111로 변경하기 위해 매개변수 전달 
			cps.changePassword("garnet2929@naver.com", "1234", "1111");
			System.out.println("암호를 성공적으로 변경하였습니다.");
			
			//암호변경 실패 시 예외 처리 표시
		}catch(MemberNotFoundException e) {
			System.out.println("회원정보가 존재하지 않습니다.");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("암호를 다시 확인하세요.");
		}
	}

}
