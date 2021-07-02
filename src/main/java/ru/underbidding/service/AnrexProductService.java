package ru.underbidding.service;

import java.util.List;

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
	
	public AnrexProduct getAnrexProductByArticle (String article) {
		return anrexProductDao.getAnrexProductByArticle(article);
	}
	
	public boolean checkAnrexProductExist (AnrexProduct product) {
		return anrexProductDao.checkAnrexProductExist(product);
	}
	
	public List<AnrexProduct> getAllAnrexProducts(){
		return anrexProductDao.getAllAnrexProducts();
	}

}
