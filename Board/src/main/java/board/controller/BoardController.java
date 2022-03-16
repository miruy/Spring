package board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.domain.BoardVO;
import board.service.BoardService;

@Controller
public class BoardController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value="/board/list")
	public String list(Model model) {
		model.addAttribute("boardList",boardService.list());
		return "/board/list";
	}
	
	@RequestMapping(value="board/read/{seq}")
	public String read(Model model, @PathVariable int seq) {
		model.addAttribute("boardVO", boardService.read(seq));
		return "/board/read";
	}
	
	/*데이터를 model객체에 담아 전송할 때(해당 시점에서) 사용자가 입력한 게시글을 객체로 생성하여 함께 전송,
	 * 이유 : 객체가 없을 때에 예외를 미리 제거(사용자가 모든 항목을 입력해야지 객체가 생성되므로) 
	 */
	@RequestMapping(value="board/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVO", new BoardVO());
		return "/board/write";
	}
	
	/* BindingResult 인터페이스 : 매개변수를 Bean 에 binding 할 때 발생한 오류 정보를 받기 
	 */
	@RequestMapping(value="board/write", method=RequestMethod.POST)
	public String write(BoardVO boardVO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/board/write";
		}
		boardService.write(boardVO);
		return "redirect:/board/list";
	}
	
}
