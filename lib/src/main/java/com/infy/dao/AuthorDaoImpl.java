package com.infy.dao;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.infy.entity.Author;
import com.infy.entity.Book;

public class AuthorDaoImpl implements AuthorDao {
	
	private static final Logger logger = null;
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public Object addAuthor(Author a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(a);
		logger.info("Author saved successfully, Author Details="+a);
		return a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAuthors() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Author> authorList = session.createQuery("from Author").list();
		for(Author a : authorList){
			logger.info("Author List:"+a);
		}
		return authorList;
	}

	@Override
	public Author getAuthorById(int id) {
		Session session = this.sessionFactory.getCurrentSession();	
		Author a= (Author) sessionFactory.getCurrentSession().get(Author.class, id);
		logger.info("Author loaded successfully, Author details="+a);
		return a; 	
	}
	
//	Configuration config=new Configuration().configure().addAnnotatedClass(Book.class);
//	ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
//	SessionFactory sf=config.buildSessionFactory(sr);
//	
//	
//	
//	@Override
//	public Object addAuthor(Author a) {
//		Session s=sf.openSession();
//		Transaction tr=s.beginTransaction();
//		Author au=(Author) s.save(a);
//		tr.commit();
//		return au;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Author> getAuthors() {
//		Session s=sf.openSession();
//		Transaction tr=s.beginTransaction();
//		List<Author> authorList = s.createQuery("from Author").list();
//		for(Author a : authorList){
//			logger.info("Author List:"+a);
//		}
//		tr.commit();
//		return authorList;
//	}
//	
//	
//	@Override
//	public Author getAuthorById(int id) {
//		Session s=sf.openSession();
//		Transaction tr=s.beginTransaction();
//	    Author a=(Author) s.get(Author.class,id);
//	    tr.commit();
//        return a;
//	}


}
