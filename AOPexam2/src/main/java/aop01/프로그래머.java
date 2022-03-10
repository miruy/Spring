package aop01;

public class 프로그래머 {

	public int usingComputer(String pwd) {	
		System.out.println("컴퓨터 부팅 후 " + pwd + "를 입력하고 로그인");
		
		try {
			System.out.println("코딩을 한다.");	//핵심기능 
			System.out.println("작업 종료");
		}catch(Exception e) {
			if(e.getMessage().equals("오류")) {
				System.out.println("AS신청");
			}
		}
		System.out.println("컴퓨터 종료");
		return 200; //의미없는 값 / 사용시간 
	}
}
