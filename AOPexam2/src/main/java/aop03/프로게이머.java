package aop03;

public class 프로게이머 implements 사람 {
	
	@Override
	public int usingComputer(String pwd) {	
			System.out.println("컴퓨터 게임을 한다.");	//핵심기능
			return 100;//의미없는 값 / 사용시간 
			
	}
}
