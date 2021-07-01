package ru.underbidding.service;

import ru.underbidding.dao.OtherProductDaoImp;
import ru.underbidding.model.OtherProduct;

public class OtherProductService {

	OtherProductDaoImp otherProductService = new OtherProductDaoImp();
	
	
	public void saveOtherProduct (OtherProduct product) {
		otherProductService.saveOtherProbuct(product);
	}
	
}
