package com.infy.dao;


import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;
import com.infy.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {
	
	private static final Logger logger = null;

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@Override
	public Book getBookByAuthor(int id) {
		Session session = this.sessionFactory.getCurrentSession();	
		Book b= (Book) sessionFactory.getCurrentSession().get(Book.class, id);
		logger.info("Book loaded successfully, Book details="+b);
		return b; 	
	}

	
//	Configuration config=new Configuration().configure().addAnnotatedClass(Book.class);
//	ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
//	SessionFactory sf=config.buildSessionFactory(sr);
//	Session s=sf.openSession();
//	Transaction tr=s.beginTransaction();
//	
//	@Override
//	public Book getBookByAuthor(int id) {
//	Book b=(Book) s.get(Book.class,id);
//        return b;
//	}
//	tr.commit();

}

