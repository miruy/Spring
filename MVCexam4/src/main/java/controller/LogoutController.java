package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//로그인 유지기능을 제거하는 클래스, HttpSession제거(로그아웃을 위한 컨트롤러 클래스)
@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();	//invalidate() : 세션 및 세션에 속해있는 값들을 모두 없애는 메서드
		return "redirect:/main";	//프로세스 상에서 logout을 처리하여 사용자에게는 logout실행 시 바로 메인화면이 보이도록
	}
}
