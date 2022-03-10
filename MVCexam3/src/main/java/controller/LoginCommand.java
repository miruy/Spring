package controller;

//view페이지에 보여질 로그인 폼에 입력한 값을 전달받기 위한 객체관리클래스(따로 로그인 요청을 처리하는 클래스도 작성할 예정) 
public class LoginCommand {
	private String email;
	private String password;
	private boolean rememberEmail;	//이메일 인증 시 email의 값과 rememberEmail의 값이 일치하면 참
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRememberEmail() {
		return rememberEmail;
	}
	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}
	
}
