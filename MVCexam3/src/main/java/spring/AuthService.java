package spring;

//이메일과 비밀번호가 일치하면 AuthInfo객체를 생성하는 AuthService클래스
public class AuthService {
	private MemberDao memberDao;
	
	//memberDao객체를 전달받아 해당 클래스의 선언되어 있는 memberDao객체에 저장하는 메서드
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//이메일과 비밀번호를 매개변수로 전달받아 일치하면 인증객체를 생성, 반환하는 메서드
	public AuthInfo authenticate(String email, String password) {
		
		//memberDao의 기능 중 이메일로 회원을 검색하는 기능으로 회원검색 실행
		Member member = memberDao.selectByEmail(email);	
		if(member == null) {	//이메일로 회원 검색 시 등록된 이메일이 아니라면(회원이 아니라면)
			throw new IdPasswordNotMatchingException();	//예외처리(해당 예외처리코드 이유 : 틀린부분을 알려주는 것은 보안상 좋지 않음)
		}
		if(!member.matchPassword(password)) {	//이메일로 회원 검색 시 이메일과 비밀번호가 일치하지 않는다면
			throw new IdPasswordNotMatchingException();	//예외처리
		}
		
		//이메일과 비밀번호가 일치한다면 매개변수로 해당 회원의 id, 이름, 이메일 정보를 담은 인증객체를 생성
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}
}
