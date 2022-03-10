package spring;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDaoImpl implements MemberDao {

	private SqlSessionTemplate sqlSessionTemplate;

	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	// 수정 메서드
	@Override
	public void update(Member member) {
		sqlSessionTemplate.update("update", member);
	}

	// 등록 메서드
	@Override
	public void insert(final Member member) {
		sqlSessionTemplate.insert("insert", member);
	}

	// 이메일로 해당하는 정보 하나만 검색 메서드
	@Override
	public Member selectByEmail(String email) {
		return sqlSessionTemplate.selectOne("selectByEmail", email);
	}

	// 모든 정보 검색 메서드(반환행이 여러개면 List사용)
	@Override
	public List<Member> selectAll() {
		return sqlSessionTemplate.selectList("list");
	} 

	// 총 데이터 수 검색 메서드
	@Override
	public int count() {
		return sqlSessionTemplate.selectOne("count");
	}
	
	// 등록일로 검색 메서드
	@Override
	public List<Member> selectByRegdate(Date from, Date to){
		HashMap<String,Date> map = new HashMap<String, Date>();
		map.put("from", from);
		map.put("to", to);
		return sqlSessionTemplate.selectList("selectByRegdate", map);
	}
	
	// id로 검색 메서드
	@Override
	public Member selectById(Long id) {
		List<Member> results = sqlSessionTemplate.selectList("selectById", id);
		return results.isEmpty() ? null : results.get(0);
	}

}










