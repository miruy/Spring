package model;

public class Book {	
	//sqlmap-book.xml파일에서 쿼리문 작성 시 실제 컬럼명과 동일해야 
	//mybatis에서 해당 컬럼으로 필드를 찾아 그의 맞는 getter,setter를 불러옴으로
	//필드 선언시 컬럼 명과 동일하게 소문자로 작성하기
	
	private Long id;	//등록번호, 퀀스 값
	private String bookname;	//책 이름
	private String isbn;	//책 일련번호
	private String orgimagename;	//사용자에게 보여지는 image이름(ex:book1.jpg)
	private String storedimagename;	//폴더에 저장되는 image이름(ex:dkfiwfi)
	private String author;	//저자
	private String pubcompany;	//출판사
	private String price;	//가격
	private String contents;
	
	public Book(){}
	
	public Book(String bookname, String isbn,String orgimagename,
			String storedimagename, String author, String pubcompany, String price, String contents) {
		this.bookname = bookname;
		this.isbn = isbn;
		this.orgimagename = orgimagename;
		this.storedimagename = storedimagename;
		this.author = author;
		this.pubcompany = pubcompany;
		this.price = price;
		this.contents = contents;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getOrgimagename() {
		return orgimagename;
	}

	public void setOrgimagename(String orgimagename) {
		this.orgimagename = orgimagename;
	}

	public String getStoredimagename() {
		return storedimagename;
	}

	public void setStoredimagename(String storedimagename) {
		this.storedimagename = storedimagename;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPubcompany() {
		return pubcompany;
	}

	public void setPubcompany(String pubcompany) {
		this.pubcompany = pubcompany;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
