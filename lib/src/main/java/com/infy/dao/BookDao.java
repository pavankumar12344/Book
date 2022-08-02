package com.infy.dao;

import java.util.List;

import com.infy.entity.Book;

public interface BookDao {

		public void save(Book b);		
		public List<Book> list();
		
	}


