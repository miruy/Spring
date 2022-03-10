package examspring08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //스프링MVC에서 컨트롤러로 샤용한다고 선언
public class HelloController {
	
	//@Controller 클래스의 메서드는 매개변수로 필요한 객체들을 갯수 상관없이 넣을 수 있으며, 스프링이 제공(제공 못하는 코드라면 에러 발생)
	//Model model 은 값을 모델에 저장하여 뷰로 보여줘야 하기때문에 필요
	//@RequestParam(	//사용자가 요청한 값을 메서드의 파라미터로 전달하는 역할 
	//value="name" : name으로 들어온 값을 해당코드뒤의 String name에 대입하겠다.
	//required=true : 값이 있어야한다/false:값이 없어도됨)
	
	@RequestMapping("/hello")	//메서드가 처리할 경로 지정(사용자가 url에 요청하는 경로)
	public String hello(
			Model model, /*컨트롤러의 처리 결과를 뷰에 전달하는 역할*/
			@RequestParam(value="name", required=false)String name) {
		
		//model 객체에 view로 보여질 값을 저장
		model.addAttribute("greeting", "안녕하세용" + name);	//addAttribute : greeting 속성() 값을 설정하여 model에 저장
		
		//컨트롤러으 처리결과를 보여줄 뷰(jsp파일이므로 jsp파일의 명과 동일해야함) 지정
		return "hello";
	}
	
}
