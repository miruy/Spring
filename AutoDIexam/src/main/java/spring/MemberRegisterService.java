package spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	//회원정보를 저장(등록)하기위해 확인하는 클래스 
	
	private MemberDao memberDao;
	//회원등록이 목적인 클래스 이기때문에 회원등록 기능을 가진 Dao객체를 참조해야함 
	
	@Autowired //자동의존주입 어노테이션
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;	//= DI
	}
	
	//자동의존주입 어노테이션 생성 후 디폴트 생성자 추가 
	public MemberRegisterService() {}
	
	//등록 메서드
	//회원가입에 필요한 데이터를 저장하는 클래스의 객체생성 후 매개변수로 넘김 
	public void regist(RegisterRequest req) {
		//등록하려는 이메일 데이터를 가져와 member변수에 담은 후 
		Member member = memberDao.selectByEmail(req.getEmail());
		
		//null과 비교, null이 아니라면(기존에 있는 이메일이라면) 기존회원예외처리 표시
		if(member != null) {
			throw new AlreadyExistingMemberException(
					"이미 가입되어 있는 이메일 입니다 : " + req.getEmail());
		}
		//null과 비교, null이라면 (기존에 있는 이메일 아니라면) 회원 가입 
			Member newMember = new Member(
					req.getEmail(),	
					req.getPassword(),
					req.getName(),
					new Date());	//등록 날짜 포함 
			memberDao.insert(newMember);
			
	}
}
