package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//커맨드 객체에 저장된 값을 검증하는 클래스 
public class ChangePwdCommandValidator implements Validator {
	
	//어떤 타입의 객체를 검증할 때 이 객체(arg0)의 클래스(Class<?> : 무슨 클래스인지 모름)가 
	//Validator가 검증할 수 있는 클래스인 지를 판단하는 매서드
	@Override
	public boolean supports(Class<?> arg0) {	
		
		//반환   커맨드 클래스(객체). 클래스 정보의. arg0가 어떤 클래스/인터패이스를 상속받았는지 체크
		return ChangePwdCommand.class.isAssignableFrom(arg0);
	}
	
	
	//검증을 실행하는 메서드
	//커맨드 객체에 저장된 값을 검증하는 클래스 이므로 커맨드 클래스의 필드들을 검증하는 코드 작성
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "required");
	}
}
