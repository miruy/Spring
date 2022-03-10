package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {
	/* 조립기는 객체를 생성하고 의존 객체를 주입해주는 기능을 제공 
	 * 또한 특정 객체를 필요로하는 곳에 객체를 제공할 수 있음
	 * 객체생성 역할 
	 * Aseembler = 스프링 컨테이너 = 설정파일 = ctx.xml파일
	 */
	
	private MemberDao memberDao;
	private MemberRegisterService regSvc;	//회원가입서비스 클래스 
	private ChangePasswordService pwdSvc;	//비밀번호 변경 클래스 
	
	//디폴트 생성자 호출 시 
	//MemberDao/MemberRegisterService/ChangePasswordService 객체 생성 
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
	
}
