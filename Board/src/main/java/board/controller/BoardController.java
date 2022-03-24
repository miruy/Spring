package board.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import board.domain.BoardVO;
import board.service.BoardService;

@Controller
@SessionAttributes("boardVO")
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
	
	/*
	 * 데이터를 model객체에 담아 전송할 때(해당 시점에서) 사용자가 입력한 게시글을 객체로 생성하여 함께 전송,
	 * 이유 : 객체가 없을 때에 예외를 미리 제거(사용자가 모든 항목을 입력해야지 객체가 생성되므로) 
	 */
	@RequestMapping(value="board/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVO", new BoardVO());
		return "/board/write";
	}
	
	/* 
	 * BindingResult 인터페이스 : 매개변수를 Bean 에 binding 할 때 발생한 오류 정보를 받기 인터페이스(Errors대체)
	 * 
	 * @Valid : Hibernate-validator의 어노테이션으로 이메일,신용카드 등의 형식과 안전한 HTML등의 검증 기능을 제공함
	 * 	-> (정규표현식으로 형식을 선언하지 않고, VO에 선언된 필드위에 의미를 가지는 어노테이션 설정으로 대체)
	 */
	@RequestMapping(value="board/write", method=RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/board/write";
		}
		boardService.write(boardVO);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/edit/{seq}", method=RequestMethod.GET)
	public String edit(@PathVariable int seq, Model model) {
		BoardVO boardVO = boardService.read(seq);
		model.addAttribute("boardVo", boardVO);
		return "/board/edit";
	}
	
	/*
	 * SessionStatus : 스프링이 제공, Session에 남긴 데이터를 정리하는 인터페이스,
	 * 컨틀로러클래스 위에 SeesionAttribute()라고 선언한 후 
	 * model.addAttribute()를 하면 model에 담아 보낸 key와 value가 Session에 저장되고
	 * 다음에 동일한 키로 요청이 왔을 때 세션에 저장되어 있던 해당 키의 데이터를 찾을 수 있음 
	 * SessionStatus 적용 전 : 데이터 전송과정에서 자동으로 바인딩 되지 못한 값이 0으로 초기화 되기 때문에 DB의 저장된 값과 일치하지 않는다는 에러 발생 
	 * SessionStatus 적용 후 : 세션에 값을 저장해놓기 때문에 DB와 값 일치  
	 */
	@RequestMapping(value="/board/edit/{seq}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute BoardVO boardVO, BindingResult result, int pwd, SessionStatus sessionStatus, Model model) {
		if(result.hasErrors()) {
			return "/board/edit";
		}else {
			if(boardVO.getPassword() == pwd) {
				boardService.edit(boardVO);
				sessionStatus.setComplete();
				return "redirect:/board/list";
			}
		}
		model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
		return "/board/edit";
	}
	
	@RequestMapping(value="/board/delete/{seq}", method=RequestMethod.GET)
	public String delete(@PathVariable int seq, Model model) {
		model.addAttribute("seq", seq);
		return "/board/delete";
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.POST)
	public String delete(int seq, int pwd, Model model) {
		int rowCount;
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(seq);
		boardVO.setPassword(pwd);
		
		rowCount = boardService.delete(boardVO);
		
		if(rowCount == 0) {
			model.addAttribute("seq", seq);
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "/board/delete";
		}else {
			return "redirect:/board/list";
		}
		
	}
	
	@GetMapping("/board/login")
	public String kakao() {
		return "/board/list";
	}
	
	
}























