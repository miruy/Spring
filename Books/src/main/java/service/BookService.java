package service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import model.Book;
import repository.AlreadyRegisteredBookException;
import repository.BookDao;

public class BookService {
	private BookDao bookDao;

	public BookService(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> findAll() {
		return bookDao.findAll();
	}

	public Book findById(Long id) {
		return bookDao.findById(id);
	}

	public void save(Book book, MultipartFile multipartFile, HttpServletRequest request) throws IllegalStateException, IOException{
		Book alreadyRegisterBook = bookDao.findByIsbn(book.getIsbn());
		Book UnProperPrice = bookDao.findByIsbn(book.getPrice());
		
		if(alreadyRegisterBook != null) {
			throw new AlreadyRegisteredBookException(
					"이미 등록되어 있는 도서입니다. 일련번호 : " + book.getIsbn()); 
		}else {
			//사용자가 입력한 파일 이름 추출
			String orgimagename = multipartFile.getOriginalFilename();
		
			//사용자가 입력한 파일 확장자 추출(사용자가 입력한 이미지파일 이름에서 .jpg뺀 부분)
			String orgimagenameExtension = orgimagename.substring(orgimagename.lastIndexOf("."));
		
			//로컬리퍼지토리에 파일을 저장할 때 uuid값에 위에서 추출한 확장자를 붙혀 저장(로컬에 저장되는 파일 이름)(=sjf743ifhrht32 + .jpg)
			String storedimagename = UUID.randomUUID().toString().replaceAll("-", "") + orgimagenameExtension;
		
			String savePath = "/Users/kim-yurim/Desktop/workspace/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Books/resources/upload/";	//파일이 저장될 경로(서버 측)		
		
			String uploadFile = savePath + storedimagename;
		
			File file = new File(uploadFile);
			//업로드요청으로 전달받은 파일을 위에서 설정한 특정 경로에 특정 파일명으로 저장
		
			multipartFile.transferTo(file);
		    
			book.setOrgimagename(orgimagename);
			book.setStoredimagename(storedimagename);
		
			bookDao.save(book);
		}

	}

	public List<Book> search(String option, String keyword){
		return bookDao.search(option, keyword);
	}
}
