package ru.underbidding.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.underbidding.model.AnrexProduct;
import ru.underbidding.util.HibernateSessionFactoryUtil;

public class AnrexProductDaoImp implements AnrexProductDAO<AnrexProduct>{

	public void saveAnrexProbuct(AnrexProduct product) {

		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(product);
//			session.save(product.getOtherProducts());
			transaction.commit();
		} catch (Exception e) {
			System.out.println("EXCEPTION !---- Product save error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
		
	}

	public void updateAnrexProduct(AnrexProduct product) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(product);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("EXCEPTION !---- Product update error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
	}

	public AnrexProduct getAnrexProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAnrexProduct(AnrexProduct product) {
		// TODO Auto-generated method stub
		
	}

	
	
}
