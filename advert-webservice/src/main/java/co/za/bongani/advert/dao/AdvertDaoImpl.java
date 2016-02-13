package co.za.bongani.advert.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import co.za.bongani.advert.dto.Advert;

public class AdvertDaoImpl implements AdvertDao {

	@Autowired
	SessionFactory sessionFactory;
	
	private Session session;
	private Transaction transaction;

	@Override
	public boolean updateAdvert(Advert advert) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();  
		session.update(advert);  
		transaction.commit();  
		session.close(); 
		return true;
	}


	@Override
	public boolean addAdvert(Advert advert) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();  
		session.save(advert);  
		transaction.commit();  
		session.close(); 
		return true;
	}


	@Override
	public Advert getAdvertById(Long id) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();  
		Advert advert = (Advert) session.get(Advert.class, id);		
		transaction.commit(); 
		session.close();
		return advert;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advert> getAllAdverts() throws Exception {
		session = sessionFactory.openSession();
		transaction = session.getTransaction();
		List<Advert> advertList = session.createCriteria(Advert.class).list();
		transaction.commit(); 
		session.close();
		return advertList;
	}


	@Override
	public boolean deleteAdvert(Long id) throws Exception {
		Advert advert = getAdvertById(id);
		advert.setDeleted(true);
		boolean isDeleted = updateAdvert(advert);
		return isDeleted;
	}

}
