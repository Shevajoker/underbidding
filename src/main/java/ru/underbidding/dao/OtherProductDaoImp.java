package ru.underbidding.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.underbidding.model.OtherProduct;
import ru.underbidding.util.HibernateSessionFactoryUtil;

public class OtherProductDaoImp implements OtherProductDAO<OtherProduct>{

	public void saveOtherProbuct(OtherProduct product) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- Other Product save error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
	}

	public void updateOtherProduct(OtherProduct product) {
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
			System.out.println("EXCEPTION !---- Other Product save error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
	}

	public OtherProduct getOtherProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteOtherProduct(OtherProduct product) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(product);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- Other Product save error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
	}

	public OtherProduct getOtherProductByAnrexArticle(String anrexArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkOtherProductExist(OtherProduct product) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<OtherProduct> getAllOtherProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
