package com.infy.service;

import java.util.List;

import com.infy.entity.Author;
import com.infy.entity.Book;

public interface AuthorService {

	public Object addAuthor(Author a);
	public List<Author> getAuthors();
	public Author getAuthorById(int id);
	public Book getBookByAuthor(int id);
	
}

