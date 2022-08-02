package com.infy.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infy.dao.BookDao;
import com.infy.entity.Book;

public class BookMain {
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		BookDao bookDao = context.getBean(BookDao.class);
		
		Book book = new Book();
		book.setTitle("kartik"); 
		book.setAuthorName("India");
		
		bookDao.save(book);
		System.out.println("Book:"+book);
		
		List<Book> list = bookDao.list();
		for(Book b : list){
			System.out.println("Book List:"+b);
		}

		context.close();	
	}

}
