package spring;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId = 0;	//회원번호 
	
	//DB대신 Map클래스를 사용하여 데이터 저장
	private Map<String, Member> map = new HashMap<>();
	
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
