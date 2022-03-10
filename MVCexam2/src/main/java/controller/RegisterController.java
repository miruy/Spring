package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

//회원 가입시 약관을 보여주는 경로로 처리하기 위한 컨트롤러

@Controller
public class RegisterController {

	// 사용자로부터 요청받는 url경로가 /register/step1 이고, POST 전송방식일 때만 실행
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	// @RequestMapping어노테이션이 지정된 메서드에 매개변수로 선언하는 객체들은
	// 스프링이 알아서 요청파라미터(사용자가 url에 적는 요청 값)를 지정된 커맨드 객체에 set메서드를 사용하여 저장함
	// 사용자로부터 요청받는 url경로가 /register/step1 이고, POST 전송방식일 때만 실행
	// request.getParameter를 사용하려면 HttpServletRequest 클래스의 request객체를 꼭 이용해야함
	// +(수정) step3.jsp에서 <form:form>태그를 사용하여 간단하게 커맨드 객체 값을 출력하려면 
	// 반드시 커맨드 객체가 존재해야하며 step1에서 step2로 요청이 넘어갈 때 model객체에 커맨드 객체가 담겨져 넘어가야함
	@RequestMapping("/register/step2")
	public String handleStep2(
			
/* boolean agree : 커맨드 객체 값의 존재 여부, 초기화 값 : 없음 -> 값이 정상적으로 들어갔다면 : true */
			@RequestParam(value="agree", defaultValue="false")boolean agree,	
			Model model) {

		if (!agree) {
			return "register/step1";
		}
		//커맨드 객체 생성 후 model에 담아 전송
		model.addAttribute("formData", new RegisterRequest());
		return "register/step2"; // 커맨드 객체 값이 존재한다면 step2.jsp파일로 이동
	}
	// 위의 코드 실행 시 url : http://localhost:8080/MVCexam2/register/step2로 접속했을 때
	// step1로 바로 이동되며 에러페이지가 보여짐(프로그램내부에러패이지를 사용자에게 보여주는건 좋지 않으므로
	// 다른 대체페이지로 이동하도록 리다이렉트 적용(밑의 메서드))
	@RequestMapping(value = "/register/step2", method = RequestMethod.GET)
	public String handleStep2() {
		return "redirect:/register/step1";
	}

	// Controller에 커맨드 객체에 대한 setter추가(의존주입 새 필요)
	// memberRegisterService를 참조할 수 있도록 선언
	private MemberRegisterService memberRegisterService;

	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	// RegisterRequest클래스를 커멘드 객체로 지정하여 폼에서 입력받아
	// 요청과 함께 전달된 요청파라미터를 저장하고 회원가입을 처리하는 동작 추가
	// 컨트롤러에 커맨드 객체(RegisterRequest regReq)를 받아 회원가입하는 기능
	
	// +추가 @ModelAttribute("formData") : view(jsp파일)에서 커맨드객체에 접근할 변수명을 바꾸고 싶을 때 사용
	// @ModelAttribute("formData") 지정안할 경우 클래스 명의 첫글자를 소문자로 바꿔 사용하는것이 디폴트 커맨드객체 변수 명
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData")RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (AlreadyExistingMemberException e) {
			return "register/step2";
		}
	}

}