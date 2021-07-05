package ru.underbidding.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.underbidding.model.AnrexProduct;
import ru.underbidding.service.AnrexProductService;
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
			if (transaction != null) {
				transaction.rollback();
			}
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
			if (transaction != null) {
				transaction.rollback();
			}
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

	public AnrexProduct getAnrexProductByArticle(String article) {
		List<AnrexProduct> list = null;
		AnrexProduct anrexProduct = new AnrexProduct();
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			list = session.createQuery("FROM AnrexProduct WHERE anrex_article = '" + article +"'").list();
			anrexProduct = list.get(0);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- Product getAnrexProductByArticle error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
		return anrexProduct;
	}

	public boolean checkAnrexProductExist(AnrexProduct product) {
		AnrexProductService anrexService = new AnrexProductService();
		AnrexProduct anrexProduct = new AnrexProduct();
		anrexProduct = anrexService.getAnrexProductByArticle(product.getArticle());
		if (anrexProduct.getArticle() != null) {
			return true;
		} else {
		return false;
		}
	}

	public List<AnrexProduct> getAllAnrexProducts() {
		List<AnrexProduct> list = null;
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.getTransaction();
			list = session.createQuery("From AnrexProduct ORDER BY name").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- Product getAllAnrexProducts error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
		return list;
	}

	
	
}
