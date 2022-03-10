package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//회원가입 완료 후 [홈 화면 이동] 버튼 눌렀을 때 홈 화면으로 이동하는 동작을 컨드롤하는 컨트롤러
@Controller
public class MainController {
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
}
