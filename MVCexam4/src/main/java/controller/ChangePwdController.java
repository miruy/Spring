package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;

//비밀번호 변경을 처리할 컨트롤러 클래스

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	
	private ChangePasswordService changePasswordService;	//비밀번호 변경처리를 위한 참조용 
	
	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(
			@ModelAttribute("command")ChangePwdCommand pwdCmd) {	//view페이지에서 객체 이름 변경해서 사용예정
		return "edit/changePwdForm";
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String submmit(
			@ModelAttribute("command")ChangePwdCommand pwdCmd,
			Errors errors,	//에러메세지
			HttpSession session) {	//서버에 유지시키기 위함
		new ChangePwdCommandValidator().validate(pwdCmd, errors);	//에러 검증
		
		if(errors.hasErrors()) {	//에러있다면 form으로 돌아가기
			return "edit/changePwdForm";
		}
		
		//에러 없다면 세션에 저장되어있던 회원정보가 들어있는 인증 객체를 가져와 새로운 인증객체에 저장(세션에서 꺼내기 위해) 
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");	
		
		//현재 입력한 비밀번호와 세션에서 꺼내 authInfo새로운 인증객체에 저장한 기존 비밀번호와 일치하는지 확인(해당 회원이 맞는지 확인)
		try {
			changePasswordService.changePassword(
					authInfo.getEmail(),
					pwdCmd.getCurrentPassword(),
					pwdCmd.getNewPassword());
			return "edit/changePwd";	//일치하면 비밀번호 변경 허용
		}catch(IdPasswordNotMatchingException e) {
			errors.rejectValue("currentPassword", "notMatching");	//비밀번호불일치 에러
			return "edit/changePwdForm";
		}
	}
}


















