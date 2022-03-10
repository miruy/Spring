package spring;

import org.springframework.beans.factory.annotation.Autowired;

//회원정보를 출력하는 클래스(이메일로 검색)
public class MemberInfoPrinter {

	private MemberDao memDao;
	private MemberPrinter printer;
	
	@Autowired	
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	@Autowired
	public void setMemberPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	//이메일로 회원여부 검색 후 회원이면 출력하는 메서드 
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if(member == null) {
			System.out.println("회원 정보 없음!\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}
