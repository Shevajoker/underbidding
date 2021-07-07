package ru.underbidding.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.OtherProductService;
import ru.underbidding.util.HibernateSessionFactoryUtil;

public class OtherProductDaoImp implements OtherProductDAO<OtherProduct> {

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
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<OtherProduct> list = null;
		OtherProduct otherProduct = new OtherProduct();
		try {
			transaction = session.beginTransaction();
			anrexArticle = anrexArticle.trim();
			list = session.createQuery("FROM OtherProduct WHERE anrex_article = '" + anrexArticle + "'").list();
			otherProduct = list.get(0);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- Other Product getOtherProductByAnrexArticle error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return otherProduct;
	}

	public boolean checkOtherProductExist(OtherProduct product) {
		OtherProductService otherProductService = new OtherProductService();
		OtherProduct otherProduct = new OtherProduct();
		otherProduct = otherProductService.getOtherProductByAnrexArticle(product.getAnrexArticle());
		if (otherProduct.getAnrexArticle() != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<OtherProduct> getAllOtherProducts() {

		return null;
	}

	public List<OtherProduct> getOtherProductsBySiteName(String siteName) {
		List<OtherProduct> listOtherProduct = null;
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			listOtherProduct = session.createQuery("FROM OtherProduct WHERE site_name = '" + siteName + "'").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- Other Product getOtherProductsBySiteName error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
		return listOtherProduct;
	}

}
