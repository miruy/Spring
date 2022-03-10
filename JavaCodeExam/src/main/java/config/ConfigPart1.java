package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
public class ConfigPart1 {
	//자바설정파일을 두개로 나뉘어 작성 Part1 : 등록기능클래스 / 등록서비스
	
		@Bean
		public MemberDao memberDao() {
			return new MemberDao();
		}
		
		@Bean
		public MemberRegisterService memberRegSvc() {
			return new MemberRegisterService(memberDao());
		}
}
