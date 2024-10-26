package com.pa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pa.entity.Books;
import com.pa.service.BookService;
import com.pa.service.PingService;

@RestController
@RequestMapping(path = "/api")
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private PingService pingService;

	public BookController(BookService bookService, PingService pingService) {
		this.bookService = bookService;
		this.pingService = pingService;
	}
	
	@GetMapping(path = "/getall")
	public ResponseEntity<List<Books>> getBooks(@RequestParam("bookname") String bookname) {
	    List<Books> books = bookService.findByName(bookname);
	    return new ResponseEntity<List<Books>>(books, HttpStatus.OK);
	}
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping(@RequestParam("ip") String ip) {
	    String output = pingService.Ping(ip);
	    return new ResponseEntity<String>(output, HttpStatus.OK);
	}
}
