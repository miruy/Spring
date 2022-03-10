package aop07;

public class 프로그래머 implements 사람 {
	
	@Override
	public int usingComputer(String pwd) {	
			System.out.println("코딩을 한다.");	//핵심기능 
		return 200; //의미없는 값 / 사용시간 
	}
}
