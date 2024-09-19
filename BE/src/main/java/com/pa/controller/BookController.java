package com.pa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pa.entity.Books;
import com.pa.service.BookService;

@RestController
@RequestMapping(path = "/api")
public class BookController {
	@Autowired
	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping(path = "/getall")
	public ResponseEntity<List<Books>> getBooks(@RequestParam("bookname") String bookname) {
	    List<Books> books = bookService.findByName(bookname);
	    return new ResponseEntity<List<Books>>(books, HttpStatus.OK);
	}
	
}
