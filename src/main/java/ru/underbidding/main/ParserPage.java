package ru.underbidding.main;

import ru.underbidding.model.OtherProduct;

public interface ParserPage {
	public void saveProduct(String url, String anrexArticle);
	public OtherProduct parseSitePage(OtherProduct product);
	public void updateProduct(OtherProduct product);
	
	
}
