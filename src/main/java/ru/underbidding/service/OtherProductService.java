package ru.underbidding.service;

import java.util.List;

import ru.underbidding.dao.OtherProductDaoImp;
import ru.underbidding.model.OtherProduct;

public class OtherProductService {

	OtherProductDaoImp otherProductService = new OtherProductDaoImp();
	
	
	public void saveOtherProduct (OtherProduct product) {
		otherProductService.saveOtherProbuct(product);
	}
	
	public boolean checkAnrexProductExist(OtherProduct product) {
		return otherProductService.checkOtherProductExist(product);
		
	}
	
	public void updateOtherProduct(OtherProduct product) {
		otherProductService.updateOtherProduct(product);
	}

	public OtherProduct getOtherProductByAnrexArticle(String anrexArticle) {
		return otherProductService.getOtherProductByAnrexArticle(anrexArticle);
	}
	
	public List<OtherProduct> getOtherProductsBySiteName(String siteName){
		return otherProductService.getOtherProductsBySiteName(siteName);
	}
	
}
