package repository;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class MailDaoImpl implements MailDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MailDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public void createAuthKey(String mailAddress, String authKey) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mailAddress", mailAddress);
		map.put("authKey", authKey);
		
		sqlSessionTemplate.selectOne("createAuthKey", map);
	}
}
