package aop09;

public class 프로게이머 implements 사람 {
	
	@Override
	public int usingComputer(String pwd) {	
			System.out.println("게임을 한다.");
			if(pwd.equals("1234")) {
				throw new RuntimeException("컴퓨터 오류");
			}
		return 100;
			
	}
}
