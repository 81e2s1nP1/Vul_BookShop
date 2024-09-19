package com.pa.service;

import java.util.List;

import com.pa.entity.Books;

public interface BookService {
	List<Books> findByName(String nameBook);
}
