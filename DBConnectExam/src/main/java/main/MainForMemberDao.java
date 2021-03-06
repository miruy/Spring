package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Member;
import spring.MemberDao;

public class MainForMemberDao {
	
	private static MemberDao memberDao;

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		selectAll();
		updateMember();
		insertMember();
		selectAll();
		
		ctx.close();
	}

	private static void insertMember() {
		System.out.println("-----insertMember");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");	//날짜 출력 형식을 지정하는 객체 생성(원하는 출력모양으로)
		String prefix = dateFormat.format(new Date());	//오늘 날짜를 구하는 클래스 객체 생성(날짜를 구해 원하는 출력모양으로 저장) 
		Member member = 
				new Member(prefix + "@test.com",	//랜덤으로 insert하기위해 이메일 형식 데이터 입력
						prefix, 
						prefix,
						new Date());
		memberDao.insert(member);
		System.out.println(member.getId() + " 데이터 추가");
		
	}

	private static void updateMember() {
		System.out.println("-----selectAll");
		Member member = memberDao.selectByEmail("garnet2929@naver.com");
		String oldPw = member.getPassword();
		String newPw = Double.toHexString(Math.random());
		member.changePassword(oldPw, newPw);
		
		memberDao.update(member);
		System.out.println("암호 변경 : " + oldPw + " > " + newPw);
	}

	private static void selectAll() {
		System.out.println("-----updateMember");
		int total = memberDao.count();
		System.out.println("전체 데이터 : " + total);
		List<Member> members = (List<Member>)memberDao.selectAll();
		for(Member m : members) {
			System.out.println(
					m.getId() + " : " + m.getEmail() + " : " + m.getName());	
		}
		
	}

}
