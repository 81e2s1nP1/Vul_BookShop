package com.pa.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.pa.entity.Authors;
import com.pa.entity.BookDownload;
import com.pa.entity.Books;
import com.pa.repository.AuthorRepo;
import com.pa.repository.BookDownloadRepo;
import com.pa.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired 
	private BookDownloadRepo bookDownload_Repo;
	@Autowired 
	private AuthorRepo author_Repo;
	
	public BookServiceImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Books> findByName(String nameBook) {
	    String query = "SELECT * FROM books WHERE book_name LIKE '%" + nameBook + "%'";
	    List<Books> booksList = new ArrayList<>();
	    System.out.println("query: " + query);
	    try {
	        booksList = jdbcTemplate.query(query, (rs, rowNum) -> {
	            Books book = new Books();
	            book.setId(rs.getInt("id"));
	            book.setBookName(rs.getString("book_name"));
	            book.setBookSize(rs.getFloat("book_size"));
	            book.setBookDate(rs.getDate("book_date"));
	            book.setBookTopic(rs.getString("book_topic"));

	            // Converter Op_BookDownload to BookDownload & Set BookDownload data into book
	            Optional<BookDownload> Op_bookDownload = bookDownload_Repo.findById(rs.getInt("book_download_id"));
	            BookDownload bookDownload = Op_bookDownload.orElse(new BookDownload());
	            if (bookDownload != null) {
	                book.setBookDownload(bookDownload);
	            }
	            
	         // Converter Op_Authors to Authors & Set author data into book
	            Optional<Authors> Op_Author = author_Repo.findById(rs.getInt("authors_id"));
	            Authors author = Op_Author.orElse(new Authors());
	            if (author != null) {
	                book.setAuthors(author);
	            }
	            
	            return book;
	        });
	    } catch (DataAccessException e) {
	        System.err.println("Error executing query: " + e.getMessage());
	    }
	    
	    System.out.println("debug get books: " + booksList);
	    return booksList;
	}


}
