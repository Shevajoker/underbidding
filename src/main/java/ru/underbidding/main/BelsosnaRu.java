package ru.underbidding.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.OtherProductService;

public class BelsosnaRu implements ParserPage{
	private String siteName = "belsosna.ru";

	public void saveProduct(String url, String anrexArticle) {
		OtherProduct otherProduct = new OtherProduct();
		BelsosnaRu belsosnaRu = new BelsosnaRu();
		otherProduct.setUrl(url);
		otherProduct.setAnrexArticle(anrexArticle);
		otherProduct.setSateName(siteName);

		OtherProductService otherProductService = new OtherProductService();

		if (otherProductService.checkAnrexProductExist(otherProduct)) {
			otherProduct = otherProductService.getOtherProductByAnrexArticle(anrexArticle, otherProduct.getSateName());
			otherProduct.setUrl(url);
			otherProduct = belsosnaRu.parseSitePage(otherProduct);
			otherProductService.updateOtherProduct(otherProduct);
		} else {
			otherProduct = belsosnaRu.parseSitePage(otherProduct);
			otherProductService.saveOtherProduct(otherProduct);
		}
	}

	public OtherProduct parseSitePage(OtherProduct product) {
		String article;
		String name;
		int priceActual;
		int priceOld;
		
		String url = product.getUrl();
		

		Document doc = null;
		try {
			doc = Jsoup.connect(url)
					.userAgent("Chrome/4.0.249.0 Safari/532.5")
					.referrer("https://belsosna.ru")
					.get();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		Elements data = doc.select(".PROPERTY_ARTNUMBER").select("td");
		
		article = data.get(1).text();
		article = "belsosna";
		
		data = doc.select("h1");
		name = data.get(0).text();

		data = doc.select(".pip__price");
		String st = data.get(0).text();
		st = st.replaceAll("\\s+", "");
		priceActual = Integer.parseInt(st);
	
		try {

			data = doc.select(".pip-oldprice__value");
			st = data.get(0).text().replaceAll("\\s+", "");
			priceOld = Integer.parseInt(st);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("No Sale!");
			System.out.println(e.getMessage());
			priceOld = 0;
		}
		
		product.setArticle(article);
		product.setName(name);
		product.setPriceActual(priceActual);
		product.setPriceOld(priceOld);
		product.setSateName(siteName);
		return product;
	}

	public void updateProduct(OtherProduct product) {
		BelsosnaRu belsosnaRu = new BelsosnaRu();
		OtherProductService otherProductService = new OtherProductService();
		product = belsosnaRu.parseSitePage(product);
		otherProductService.updateOtherProduct(product);
	}

}
