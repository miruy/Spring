package service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import model.MailHandler;
import repository.MailDao;

/*
 * 내부에서 자바 로직을 처리하는 어노테이션,
 * @Controller, @Repository와 같이 객체의 상태를 관리하는 저장소에(루트컨테이너) DB작업을 위한 DAO객체(bean)생성
 */
@Service
public class MailServiceImpl implements MailService{
	
	private MailDao mailDao;
	
	private JavaMailSender mailSender;
	
	public MailDao getMailDao() {
		return mailDao;
	}
	
	public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
	}

	@Override
	public MailHandler checkLoginBefore(String value) throws Exception {
		return null;
	}
	
	
	
}
