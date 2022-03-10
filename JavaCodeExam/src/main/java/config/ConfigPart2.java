package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;

@Configuration
public class ConfigPart2 {
	//자바설정파일을 2개로 나뉘어 설정 Part2 : 의존객체(memberDao) / 등록 기능 클래스 / 회원정보 출력 클래스 
	
	@Autowired
	private ConfigPart1 configPart1;	//configPart1객체를 의존 주입 받도록 지정 
//	private MemberDao memberDao;
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setMemberDao(configPart1.memberDao());
		infoPrinter.setMemberPrinter(printer());
		return infoPrinter;
	}
}
