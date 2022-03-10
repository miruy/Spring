package spring;

public class RegisterRequest {
	//회원 가입 시 필요한 데이터를 등록하는 클래스 
	private String email;
	private String password;	//회원 가입 시 처음 입력한 비밀번호 
	private String confirmPassword;	//확인용 비밀번호(컨펌)
	private String name;
	
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//처음 입력한 비밀번호와 두번째 입력한 비밀번호가 맞는지 확인하는 메서드(참, 거짓)
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword); 
	}
	
}
