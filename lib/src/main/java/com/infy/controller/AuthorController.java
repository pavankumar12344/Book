package com.infy.controller;
import com.infy.service.AuthorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.Author;
import com.infy.entity.Book;



@RestController
public class AuthorController {
	
	private AuthorService authorService;
	
	@Autowired(required=true)
	@Qualifier(value="authorService")
	public void setBookService(AuthorService as){
		this.authorService = as;
	}
	
	@PostMapping("/addAuthor")
	public Object addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);
	}
	
	@GetMapping("/getAuthors")
	public List<Author> getAuthors(){
		return authorService.getAuthors();
	}
	
	@GetMapping("/getByid/{id}")
	public Author getAuthorById(@PathVariable int id) {
		return authorService.getAuthorById(id);
	}
	
	@GetMapping("/getBookByAuthor/{id}")
	public Book getBookByAuthor(@PathVariable int id) {
		return authorService.getBookByAuthor(id);
	}
	
}

