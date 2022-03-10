package repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import model.Book;

public class BookDaoImpl implements BookDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BookDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	//도서 전체 목록
	@Override
	public List<Book> findAll(){
		return sqlSessionTemplate.selectList("findAll");
	}
	
	//도서 상세 정보 보기
	@Override
	public Book findById(Long id) {
		return sqlSessionTemplate.selectOne("findById", id);
	}
	
	//도서 등록
	@Override
	public void save(final Book book) {
		sqlSessionTemplate.insert("saveForm", book);
	}
	
	//도서 이름 또는 저자로 검색(or연산자, %이용하여 쿼리문 작성하기, 반환 되는 값이 여러개 일수있으므로 반환형 : List)
	@Override
	public List<Book> search(String option, String keyword) {
		System.out.println("impl-hashbefore" + keyword);
		System.out.println("impl-hashbefore" + option);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("option", option);
		map.put("keyword", keyword);
		System.out.println("impl-hashafter" + map.get("keyword"));
		System.out.println("impl-hashafter" + map.get("option"));
		return sqlSessionTemplate.selectList("search", map);
	}
	
}
