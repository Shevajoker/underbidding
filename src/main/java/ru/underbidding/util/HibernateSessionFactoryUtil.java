package ru.underbidding.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import ru.underbidding.model.AnrexProduct;
import ru.underbidding.model.OtherProduct;



public class HibernateSessionFactoryUtil {

public static SessionFactory sessionFactory;
	
	public HibernateSessionFactoryUtil() {}
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			try {
				Configuration config = new Configuration().configure(); 
				config.addAnnotatedClass(AnrexProduct.class);
				config.addAnnotatedClass(OtherProduct.class);
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
				sessionFactory = config.buildSessionFactory(builder.build());
			} catch (Exception e) {
				System.out.println("EXCEPTION !---- Bad SessionFactory ----!");
				System.out.println(e);
				System.out.println("EXCEPTION !---- Bad SessionFactory ----!");
			}
		}
		
		return sessionFactory;
	}
	
}
