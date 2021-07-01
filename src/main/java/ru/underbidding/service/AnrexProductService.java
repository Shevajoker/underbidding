package ru.underbidding.service;

import ru.underbidding.dao.AnrexProductDaoImp;
import ru.underbidding.model.AnrexProduct;

public class AnrexProductService {
	
	AnrexProductDaoImp anrexProductDao = new AnrexProductDaoImp();
	
	public void saveAnrexProduct (AnrexProduct product) {
		anrexProductDao.saveAnrexProbuct(product);
	}
	
	public void updateAnrexProduct(AnrexProduct product) {
		anrexProductDao.updateAnrexProduct(product);
	}

}
