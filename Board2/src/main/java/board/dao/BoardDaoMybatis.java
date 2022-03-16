package board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import board.domain.BoardVO;

/*
 * DB나 파일같은 외부 I/O 작업을 처리하는 어노테이션,
 * @Controller, @Service와 같이 객체의 상태를 관리하는 저장소에(루트컨테이너) DB작업을 위한 DAO객체(bean)생성
 */
@Repository
public class BoardDaoMybatis implements BoardDao{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BoardDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<BoardVO> list(){
		return sqlSessionTemplate.selectList("list");
	}
	
	@Override
	public int delete(BoardVO boardVO){
		return sqlSessionTemplate.delete("delete", boardVO);
	}
	
	@Override
	public int deleteAll(){
		return sqlSessionTemplate.delete("delete");
	}
	
	@Override
	public int update(BoardVO boardVO){
		return sqlSessionTemplate.update("update", boardVO);
	}
	
	@Override
	public void insert(BoardVO boardVO){
		sqlSessionTemplate.insert("insert", boardVO);
	}
	
	@Override
	public BoardVO select(int seq){
		BoardVO vo = (BoardVO) sqlSessionTemplate.selectOne("select", seq);
		return vo;
	}
	
	@Override
	public int updateReadCount(int seq){
		return sqlSessionTemplate.update("updateCount", seq);
	}
}
