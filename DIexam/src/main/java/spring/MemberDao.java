package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId = 0;	//회원번호(DB의 시퀀스 역할) 
	
	//DB대신 Map클래스를 사용하여 데이터 저장
	private Map<String, Member> map = new HashMap<>();
	
	//DI(의존주입)객체를 2개 이상 주입하기 위한 메서드 추가
	//즉, 객체생성시 여러개의 인자를 매개변수로 넣을 때(오버로딩 생성자) 
	public Collection<Member> selectAll(){
		return map.values();
	}
	
	//이메일 검색 메서드
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	//회원 등록 메서드 
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);	
	}
	
	//회원 정보 수정 메서드 
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
}
