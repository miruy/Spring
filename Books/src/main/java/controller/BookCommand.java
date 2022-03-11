package controller;

import org.springframework.web.multipart.MultipartFile;

public class BookCommand {
	private String isbn;
	private String bookname;
	private String author;
	private String pubcompany;
	private String price;
	private MultipartFile file;
	private String contents;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}	
	
