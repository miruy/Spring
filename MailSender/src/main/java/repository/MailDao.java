package repository;

public interface MailDao {
	public void createAuthKey(String mailAddress, String authKey) throws Exception;
}
