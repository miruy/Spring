package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigPart1;
import config.ConfigPart2;
import config.ConfigPartMain;
import config.JavaConfig2;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainTwoConfs2 {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(
						ConfigPartMain.class);
						//ConfigPartMain설정파일에 ConfigPartSub설정파일도 import(포함)되어 있으므로 
						//ConfigPartSub설정파일의 객체(Bean)도 생성할 수 있음
		
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("dbflarla4966@naver.com");
		regReq.setName("김유림");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		regSvc.regist(regReq);
		
		infoPrinter.printMemberInfo("dbflarla4966@naver.com");
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
}
