package model;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

// = mailVO
public class MailHandler {

	/*
	 * JavaMailSender : 메일 발송 기능을 위한 인터페이스 MimeMessage : 문자인코딩을 이용해 영어가 아닌 언어의 이메일도
	 * 전송하는 기능의 클래스 MimeMessageHelper : mail을 커스텀 하는 클래스()
	 */
	private JavaMailSender mailSender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;

	/*
	 * createMimeMessage() : 발신자의 기본 JavaMail세션에 대한 새로운 JavaMail MimeMessage를 생성 new
	 * MimeMessageHelper(message, true, "UTF-8") : MimeMessageHelper 객체 생성 시 생성자의
	 * 매개변수로 담은 message(MimeMessage)/true(boolean multipart)/"UTF_8"(문자 인코딩) 으로 보내는
	 * 메일을 커스텀 함
	 */
	public MailHandler(JavaMailSender mailSender) throws MessagingException {
		this.mailSender = mailSender;
		message = this.mailSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	}

	/*
	 * 전체적인 흐름: MailSender(텍스트형 메일) → MimeMessage(다양한 언어를 호환하는 메일) →
	 * messageHelper(세가지 값으로 커스텀된 이메일)
	 * 
	 * Subject, Text, From, To, send 는 Mailsender인터페이스에 정의 되어 있는 setter메서드
	 */

	// 이메일 제목을 세팅하는 setter메서드
	public void setSubject(String subject) throws MessagingException {
		messageHelper.setSubject(subject);
	}

	// 이메일 내용을 세팅하는 setter메서드
	public void setText(String htmlContent) throws MessagingException {
		messageHelper.setText(htmlContent, true);
	}

	// 보내는 사람의 이메일을 세팅하는 setter메서드
	public void setFrom(String email, String name) throws MessagingException, UnsupportedEncodingException {
		messageHelper.setFrom(email, name);
	}

	// 받는 사람의 이메일을 세팅하는 setter메서드
	public void setTo(String email) throws MessagingException {
		messageHelper.setTo(email);
	}

	// 정리 필요
	public void addInline(String contentId, DataSource dataSource) throws MessagingException {
		messageHelper.addInline(contentId, dataSource);
	}

	// MailSender인터페이스의 send()로 이메일 보내기 기능 메서드
	public void send() {
		try {
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
