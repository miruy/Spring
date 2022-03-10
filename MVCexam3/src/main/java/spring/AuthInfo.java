package spring;

//로그인을 하게 되면 세션, 쿠키, 인터셉터 등이 이슈를 처리해야하며, 이를 위해 필요한 코드들을 만들고 로그인을 구현
//로그인 성공 후 인증상태를 세션에 보관하기 위한 클래스
public class AuthInfo {	//AuthInfo : 인증
	private Long id;
	private String email;
	private String name;
	
	public AuthInfo(Long id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}
	
	
}
