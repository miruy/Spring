package survey;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller		//컨트롤러 클래스 
@RequestMapping("/survey")	//url경로 마지막 주소가 /survey면 클래스 실행 
public class SurveyController {
	
////사용자가 url경로로 /survey를 요청하면(url작성 : get방식) form()실행->survey폴더의 surveyForm.jsp로 이동 
//	@RequestMapping(method=RequestMethod.GET)
//	public String form() {
//		return "survey/surveyForm";
//	}
//	
//	//AnsweredData data를 커맨드 객체로 사용하겠다는 코드, 
//	//커멘드 객체를 사용하는 jsp파일에서 이름을 디폴트 이름(소문자)이 아닌
//	//ansData로 사용하기 위해 ModelAttibute()사용
//	@RequestMapping(method=RequestMethod.POST)
//	public String submit(@ModelAttribute("ansData")AnsweredData data) {
//		return "survey/submitted";
//	}
	
	//Model를 이용해 controller가 view로 데이터를 전송 할 수 있도록 코드 수정
	
//	//설문조사 양식 메서드 - get방식으로 데이터 전송 요청 시에만 form메서드 실행(사용자가 직접 url로 /survey 경로(surveyForm.jsp 페이지) 요청해야함
//	@RequestMapping(method=RequestMethod.GET)
//	public String form(Model model) {
//		
//		//질문 및 답변 항목(내용)이 list형태로 담겨 저장하는 createQuestions()메서드를 호출하여 questions변수에 저장(현재 questions 값  :null)
//		List<Question> questions = createQuestions();	//createQuestions()메서드를 호출하는 이 시점에서 밑의 createQuestions()실행되고 questions 값 들어감
//		
//		//model객체에 질문 및 답변 항목 객체를 담아 survey폴더에 surveyForm.jsp파일로 전송(브라우저로 보여짐)
//		model.addAttribute("questions", questions);
//		return "survey/surveyForm";
//	}
	
	//form()메서드에서 컨트롤러가 한 역할 : 
	//1. model객체에 질문 및 답변 항목 객체를 저장
	//2. survey폴더에 surveyForm.jsp파일로 전송(브라우저로 보여짐)
	//컨트롤러의 역할을 ModelAndView클래스를 이용해 한번에 묶어서 처리할 메서드 생성
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(Model model) {
		List<Question> questions = createQuestions();
		ModelAndView mav = new ModelAndView();	//ModelAndView 클래스 객체 생성
		mav.addObject("questions", questions);	//mav객체에 질문 및 답변 항목 객체를 저장
		mav.setViewName("survey/surveyForm");	//mav객체가 전송할 view파일 이름을 문자열로 세팅
		return mav;
	}
	
	//질문 및 답변 항목(내용)을 작성하고 list형태로 저장하는 메서드
	//Arrays.asList() : 일반 배열을 ArrayList로 바꿔야 할 때 사용(배열의 크기 변경, 인덱스 값을 추가하거나 삭제해야할 경우)
	private List<Question> createQuestions(){
		Question q1 = new Question("당신의 역할은?", /*String title*/
						Arrays.asList("서버","프론트","풀스택"));	/*List<Question> option*/
		
		Question q2 = new Question("주로 사용하는 개발 도구는?",
				Arrays.asList("이클립스","인텔리J","서브라임"));
		
		Question q3 = new Question("하고 싶은 말?");
		
		return Arrays.asList(q1, q2, q3);
	}

	//설문조사 결과를 보여주는 매서드 - POST방식으로 데이터 전송시에만 메서드 실행(surveyForm.jsp에서 submitted.jsp로 페이지 이동시에는 POST방식으로 전송)
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("ansData")AnsweredData data) {	/*AnsweredData data -> ansData로 변수 명 수정 후 submitted.jsp에서 사용*/
		return "survey/submitted";
	}


}




