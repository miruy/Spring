package spring;

import java.util.Collection;
//2개 이상의 의존객체를 생성자로 주입받기위한 클래스(= 객체생성시 여러개의 인자를 매개변수로 넣을 때)  
public class MemberListPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members) {
			printer.print(m);
		}
	}
}
