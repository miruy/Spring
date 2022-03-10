package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.RegisterRequest;

//커맨드 객체의 값 검증 및 에러메세지 처리 클래스
public class RegisterRequestValidator implements Validator{

	//이메일 형식을 문자열 그대로 변수에 저장 
	private static final String emailRegExp =
							"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
									"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	//패턴 클래스 : compile()메서드의 매개변수로 전달된 문자열 형식을 패턴으로 지정하는 클래스
	private Pattern pattern;
	
	//사용자가 이메일 입력칸에 작성하는 문자를 이메일 형식으로 전달받는 생성자
	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	//supports() : 객체의 값(Class<?> arg0)이 검증 가능한지 참,거짓으로 반환하는 메서드 
	@Override
	public boolean supports(Class<?> arg0) {
		return RegisterRequestValidator.class.isAssignableFrom(arg0);
		/*스프링 MVC에서 전달받은 객체를 자동으로 검증할 경우 올바르게 구현해야 함
		 * 현재 실습에서는 사용햐지 않음*/
	}
	
	//validate() : 검증 객체(target)를 검증을 실행하는 메서드 / 에러 발생 시 Errors errors에 에러저장
	@Override
	public void validate(Object target, Errors errors) {
		//target : 검사 대상 객체
		//errors : 검사 결과 에러코드를 저장하는 객체
		
		//회원 등록 객체(regReq)에 검증객체를 대입
		RegisterRequest regReq = (RegisterRequest) target;
		
		//검증객체가 대입된 회원등록(회원정보) 객체으 이메일이 null이거나 
		//이메일의 문자열 좌우에서 공백을 제거(trim())한 후의 형태가 기본 이메일 형식과 다르다면
		if(regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
			
			//rejectValue() : 하나의 필드에 하나의 에러코드를 추가하는 메서드
			//errore객체에 "email"이라는 필드에 "required"(필수)라는 에러를 추가
			errors.rejectValue("email", "required");
		}else {
			//이메일 검증 시 에러가 없다면
			//회원등록객체의 이메일을 가져와 저장 (regReq.getEmail())
			//대상 문자열의 패턴을 해석하고 주어진 패턴과 일치하는지 판별하는 클래스(Matcher)에
			Matcher matcher = pattern.matcher(regReq.getEmail());
			
			//해당 이메일이 주어진 이메일패턴과 일치하지 않다면
			if(!matcher.matches()) {
				//errore객체에 "email"이라는 필드에 "bad"라는 에러를 추가
				errors.rejectValue("email", "bad");
			}
		}
		//ValidationUtils클래스 : 객체의 값을 검증하는 코드를 간결하게 만들어주는 클래스
		//password검증은 ValidationUtils클래스 사용(의미는 rejectValue()와 같음) 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
		if(!regReq.getPassword().isEmpty()) {
			if(!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}
}




















