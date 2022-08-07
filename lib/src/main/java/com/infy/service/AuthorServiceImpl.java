package com.infy.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.AuthorDao;
import com.infy.dao.BookDao;
import com.infy.entity.Author;
import com.infy.entity.Book;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	
	private AuthorDao authorDao;
	
	private BookDao bookDao;

	
	public AuthorServiceImpl(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
    public Object addAuthor(Author author){
	    return this.authorDao.addAuthor(author);
	}

	@Override
	public List<Author> getAuthors() {
		return this.authorDao.getAuthors();
	}

	@Override
	public Author getAuthorById(int id) {
		return this.authorDao.getAuthorById(id);
	}

	@Override
	public Book getBookByAuthor(int id) {
		return this.bookDao.getBookByAuthor(id);
	}


}

