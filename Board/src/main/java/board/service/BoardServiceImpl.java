package board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import board.dao.BoardDao;
import board.domain.BoardVO;

/*
 * 내부에서 자바 로직을 처리하는 어노테이션,
 * @Controller, @Repository와 같이 객체의 상태를 관리하는 저장소에(루트컨테이너) DB작업을 위한 DAO객체(bean)생성
 */
@Service
public class BoardServiceImpl implements BoardService{
	private BoardDao boardDao;
	
	public BoardDao getBoardDao() {
		return boardDao;
	}
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<BoardVO> list(){
		return boardDao.list();
	}
	
	
	@Override
	public int delete(BoardVO boardVO){
		return boardDao.delete(boardVO);
	}
	
	@Override
	public int edit(BoardVO boardVO){
		return boardDao.update(boardVO);
	}
	
	@Override
	public void write(BoardVO boardVO){
		boardDao.insert(boardVO);
	}
	
	@Override
	public BoardVO read(int seq){
		boardDao.updateReadCount(seq);
		return boardDao.select(seq);
	}
}
