package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

//자바코드로 설정파일 생성(=appCtx.xml)

//@Configuration : 해당클래스가 스프링설정(설정파일로)으로 사용된다는 것을 명시하는 어노테이션 
@Configuration	
public class JavaConfig {
	
	//객체 생성하고자 하는 클래스의 타입을 반환형으로 디폴트생성자를 생성 한 후 객체생성코드를 반환 
	//@Bean어노테이션을 사용하면 설정파일에서 설정하는 것과 같이 객체가 생성됨
	//자바코드로 설정파일 생성 시! @Resource 어노테이션은 삭제한 후 생성해야함(해당 어노테이션은 ctx.xml에 사용하는 어노테이션이므로)
	
	@Bean	
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setMemberPrinter(printer());
		return infoPrinter;
	}
}
