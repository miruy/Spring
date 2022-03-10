package spring;

public class AlreadyExistingMemberException extends RuntimeException{
	//멤버 등록 시 이메일을 검색하여 있는 이메일인지 확인 
	//있는 이메일이라면 표시할 예외처리 생성 
	public AlreadyExistingMemberException(String message) {
		super(message);
	}
}
