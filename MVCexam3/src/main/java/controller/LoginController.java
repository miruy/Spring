package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.AuthInfo;
import spring.AuthService;
import spring.IdPasswordNotMatchingException;

//로그인 요청을 처리하는 클래스

@Controller
@RequestMapping("/login")
public class LoginController {
	private AuthService authService;	//이메일과 비밀번호 인증 객체 선언(인증 시 참조)
	
	//인증 메서드 
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	//사용자가 브라우저 url 경로로 login/loginForm 요청시에만 실행
	@GetMapping
	public String form(LoginCommand loginCommand,
						@CookieValue(value="REMEMBER", required=false)Cookie cookie) {
		if(cookie != null) {
			loginCommand.setEmail(cookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "login/loginForm";
	}
	
	//사용자가 loginForm에서 값 입력 후 전송버튼을 누르면 해당 메서드 실행(로그인 처리메서드)
	// +추가 로그인을 유지시키는 기능 : HttpSession이용 - 로그인을 유지하는 기능의 객체가 항상 생성되어져 있어야 함으로 
	//	같은 기능이지만 차이점 HttpSessios : 항상 session을 생성 / HttpServletRequest : 필요한 시점에만 HttpSession을 생성
	// submit()매개변수로 유지 객체(session) 추가 전달 -> 로그인에 성공하면 HttpSeseeion에 authInfo속성의 authInfo객체를 저장
	@PostMapping
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		
		//LoginCommand클래스에서 전달받은 객체(메서드의 매개변수로 전달받은 loginCommand, errors)를 검증하는 생성자를 호출하여 
		//검증 객체 생성(변수저장X) 후 유효성 검증
		new LoginCommandValidator().validate(loginCommand, errors);	
		
		if(errors.hasErrors()) {	//에러가 하나라도 발생했다면
			return "login/loginForm";	//로그인 폼으로 돌아가기
		}
		
	//에러가 발생하지 않았다면 인증 객체 생성하여 인증 실행
	//	+추가 LoginController는 로그인에 성공하면 HttpSession에 authInfo 속성으로 인증정보 객체를 저장
		try {
			AuthInfo authInfo = authService.authenticate(
					loginCommand.getEmail(), 
					loginCommand.getPassword());
			
			//세션 객체에 로그인 인증 정보 저장(이거 안하면 로그인 유지 안됌)
			session.setAttribute("authInfo", authInfo);
			
			Cookie rememberCookie = 
					new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			
			if(loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60*60*24*30);
			}else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			
			return "login/loginSuccess";
		}catch(IdPasswordNotMatchingException e) {
			errors.reject("IdPasswordNotMatching");
			return "login/loginForm";
		}
	}
	
}



















