
package service;

import model.MailHandler;


public interface MailService {
	public MailHandler checkLoginBefore(String value) throws Exception;
}
