package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AlreadyRegisterBookValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> arg0) {
		return BookCommand.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookname", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pubcompany", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");
		ValidationUtils.rejectIfEmpty(errors, "file", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contents", "required");
	}
}
