package ru.underbidding.dao;

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
			System.out.println("EXCEPTION !---- Other Product save error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
	}

	public void updateOtherProduct(OtherProduct product) {
		// TODO Auto-generated method stub
		
	}

	public OtherProduct getOtherProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteOtherProduct(OtherProduct product) {
		// TODO Auto-generated method stub
		
	}

}
