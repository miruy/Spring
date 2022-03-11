package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Book;

public class bookRowMapper implements RowMapper<Book>{

	@Override //command+option+s
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book(
				rs.getString("BOOKNAME"),
				rs.getString("ISBN"),
				rs.getString("ORGIMAGENAME"),
				rs.getString("STOREDIMAGENAME"),
				rs.getString("AUTHOR"),
				rs.getString("PUBCOMPANY"),
				rs.getString("PRICE"),
				rs.getString("CONTENTS"));
		book.setId(rs.getLong("ID"));
		return book;
	}	
}
