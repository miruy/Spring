package aop12;

public class 프로그래머 implements 사람 {
	
	@Override
	public int usingComputer(String pwd) {	
			System.out.println("코딩을 한다.");
			if(pwd.equals("1234")) {
				throw new RuntimeException("컴퓨터 오류");
			}
		
		return 200;
	}
}
