package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
	//암호변경 클래스 
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//Transactional어노테이션 선언(여러개의 쿼리를 한꺼번에 처리하다가 예외가 발생하면 자동으로 rollback, 완료되면 자동으로 commit을 해줌)
	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		//(비밀번호 변경 전)기존 회원이 맞는지 확인용으로 
		//이메일 데이터를 가져와 member 변수에 저장 
		Member member = memberDao.selectByEmail(email);
		
		//member가 null이라면(기존 회원이 아니라면) 기존 회원이 아니라는 예외처리 표시 
		if(member == null) {
			throw new MemberNotFoundException();
		}else {
			member.changePassword(oldPwd, newPwd);
			memberDao.update(member);
		}
	}
}
