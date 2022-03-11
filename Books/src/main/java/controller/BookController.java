package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.Book;
import service.BookService;
 
@Controller
@RequestMapping("/books")
public class BookController {

	private BookService bookService;
	
	public BookController() {}

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * 도서 전체 조회
	 */
	@GetMapping("/list")
	public String findAll(Model model) {
		List<Book> books = bookService.findAll();
		
		model.addAttribute("books", books);
		return "books/book_list";
	}
	
	/**
	 * 도서 단건 조회
	 */
	@GetMapping("/read/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findById(id);
		if (book == null) {
			return "redirect:/books/list";
		}
		
		model.addAttribute("book", book);
		return "books/book_detail";
	}
	
	/**
	 * 도서 등록
	 */
	@GetMapping("/add")
	public String saveForm() {
		return "books/book_reg_form";
	}
	@PostMapping("/add")
	public String save(@ModelAttribute("bookCmd") BookCommand bookCmd, Errors errors, HttpServletRequest request) throws IllegalStateException, IOException {
		
		new AlreadyRegisterBookValidator().validate(bookCmd, errors);
		if(errors.hasErrors()) {
			return "books/book_reg_form";
		}
		
		Book book = new Book();
		book.setAuthor(bookCmd.getAuthor());
		book.setBookname(bookCmd.getBookname());
		book.setContents(bookCmd.getContents());
		book.setIsbn(bookCmd.getIsbn());
		book.setPrice(bookCmd.getPrice());
		book.setPubcompany(bookCmd.getPubcompany());
		
		MultipartFile multipartFile = bookCmd.getFile();
		
		bookService.save(book, multipartFile, request);
		return "redirect:/books/list";
	}

	/**
	 * 도서 검색
	 */
	@RequestMapping("/search")
	public String search (@ModelAttribute("searchCmd") SearchCommand searchCmd, Model model){
		if(searchCmd.getKeyword() != null && searchCmd.getOption() != null) {
			List<Book> books = bookService.search(
					searchCmd.getOption(), 
					searchCmd.getKeyword());
			model.addAttribute("books", books);
		}
		return "books/book_list";
	}
}
