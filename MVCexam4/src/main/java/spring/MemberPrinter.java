package spring;
//객체가 담고 있는 정보를 콘솔에 출력해주는 클래스 
public class MemberPrinter {
	public void print(Member member) {
		System.out.printf(
			"회원 정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n",
		member.getId(), member.getEmail(), 
		member.getName(), member.getRegisterDate());
	}
}
