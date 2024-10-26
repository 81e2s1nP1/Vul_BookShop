package com.pa.converter;

import org.springframework.stereotype.Component;

import com.pa.entity.BookDownload;
import com.pa.entity.Books;

@Component
public class Converter {
	
	//converter Books to Book_Download
	 public BookDownload convert(Books source) {
		 BookDownload bookDownload = new BookDownload();
		 bookDownload.setId(source.getBookDownload().getId());
		 bookDownload.setBookIMG(source.getBookDownload().getBookIMG());
		 bookDownload.setBookURL(source.getBookDownload().getBookURL());
		 return new BookDownload();
	    }
}
