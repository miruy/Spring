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
	
	//도서 이름 또는 저자로 검색
	@Override
	public List<Book> search(String option, String keyword) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("option", option);
		map.put("keyword", keyword);
		return sqlSessionTemplate.selectList("search", map);
	}
	
	//일련번호로 검색(이미 등록되어 있는 도서는 에러발생)
	public Book findByIsbn(String isbn) {
		return sqlSessionTemplate.selectOne("findByIsbn", isbn);
	}
}



























