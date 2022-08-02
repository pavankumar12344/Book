package com.infy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infy.entity.Book;

public class BookDaoImpl implements BookDao{

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void save(Book b) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(b);
		tx.commit();
		session.close();
	}

	@Override
	public List<Book> list() {
		Session session = this.sessionFactory.openSession();
		List<Book> bookList = session.createQuery("from Book").list();
		session.close();
		return bookList;
	}

}

