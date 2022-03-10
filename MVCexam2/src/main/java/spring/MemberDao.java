package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

//RowMapper : DB의 가로 행(insert내용)의 데이터를 꺼내 자바코드로 저장하는 인터페이스 
//-> 그냥 인터페이스는 객체생성이 부가능하므로 클래스안에 클래스를 만들어(익명중첩클래스)바로 정의해야함 
//익명중첩클래스 : 클래스이름은 같지만 뒤에 $1, $2...이 붙으면서 익명중첩클래스가 됨 
//하지만, 모든 메서드 또는 클래스에 RowMapper인터페이스를 구현하는 중첩클래스를 생성하면 중복이 많아지므로
//따로 RowMapper클래스를 생성하여 함수(=클래스 명)로 사용하는 방법을 지향함  	

	// 이메일로 해당하는 정보 하나만 검색 메서드
	// 반환 값이 있으므로 변수를 생성하여 쿼리 전송
	public Member selectByEmail(String email) {
		List<Member> result = jdbcTemplate.query("select * from MEMBER where EMAIL = ?", new MemberRowMapper(), email);
		return result.isEmpty() ? null : result.get(0);
	}

	// 모든 정보 검색 메서드(반환행이 여러개면 List사용)
	public List<Member> selectAll() {
		List<Member> result = jdbcTemplate.query("select * from MEMBER", new MemberRowMapper());
		return result;
	}
	
	// 이후, mapRow익명중첩클래스 부분이 중복되므로 MemberRowMapper클래스를 따로 생성하여 위의 코드 수정함 

	// 총 데이터 수 검색 메서드
	// queryForObject : 결과 반환행이 하나 일 경우만 사용 가능
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
		return count;
	}

	// 수정 메서드
	// jdbcTemplate.update()메서드를 사용할 경우 바인딩변수의 값은 매개변수 뒷 부분에 정의하면 됨 
	public void update(Member member) {
		jdbcTemplate.update(
				"update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
				member.getName(), member.getPassword(), member.getEmail());
	}
	
	//등록 메서드, keyHolder클래스를 이용하여 자동으로 생성되는 키 값을 구하는 기능을 포함 
	// +추가 pstmt로 직접 세팅(경우의따라 직접 바인딩변수(?)를 직접 세팅할 수 있음)
	// createPreparedStatement(Connection con) 메서드를 가진 PreparedStatementCreator 인터페이스가 자바에 구현되어 있음
	//위의 수정메서드와 비교하며 해석해보기 
	public void insert(final Member member) {
		
		//KeyHolder : pk, 시퀀스 값을 저장하여 insert시 알려주는 인터페이스 
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		//직접 값을 세팅하기 위해 PreparedStatementCreator생성자를 매개변수로 전달(익명중첩클래스생성하여 사용
		jdbcTemplate.update(new PreparedStatementCreator() {	
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				// 파라미터로 전달받은 Connection con을 이용해 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER (ID, EMAIL, PASSWORD, NAME, REGDATE) values (MEMBER_SEQ.nextval, ?,?,?,?)",
								new String[] {"ID"});

				// 인덱스 파라미터 값 설정
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				
				// 생성된 PreparedStatement 객체 반환
				return pstmt;
			}
		}, keyHolder);	//insert마다 pk,시쿼스를 keyHolder객체를 매개변수로 전달(keyHolder도 활용해라)
		Number keyValue = keyHolder.getKey();	//keyHolder객체에서 pk,시뭔스 값을 꺼내 keyValue변수에 저장 
		
		//keyValue변수에 저장한 pk,시퀀스값을 새로 insert되는 데이터(member)의 id(=pk,시퀀스)로 세팅
							//xxxValue() : Number클래스로 받은 객체를 모든 기본타입형으로 변환할 수 있는 메서드  
		member.setId(keyValue.longValue());	//longValue() : long타입의 값
		
	}

}
















