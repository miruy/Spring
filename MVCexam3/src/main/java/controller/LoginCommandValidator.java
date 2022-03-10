package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//LoginCommand클래스에서 전달받은 값을 검증하는 클래스
public class LoginCommandValidator implements Validator{	//Validator : 유효성 검증 인터페이스
	//Validator인터페이스를 구현받은 클래스(검증 클래스)의 경우 오버라이딩된 supports(), validate()를 꼭 정의해야함
	//supports()와 validate()는 validator인터페이스의 기본적으로 구성되어있는 메서드들이므로 오버라이딩하여 사용
	
	//객체의 값이 검증 가능한 값인지를 판단하는 메서드 
	@Override
	public boolean supports(Class<?> arg0) {
		return LoginCommand.class.isAssignableFrom(arg0);
	}
	
	//검증을 실행하는 메서드(target 객체 검증 시 에러 발생하면 errors객체에 담아 전달)
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
	}
}
