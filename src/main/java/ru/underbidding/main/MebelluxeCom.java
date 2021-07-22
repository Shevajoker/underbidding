package ru.underbidding.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.OtherProductService;

public class MebelluxeCom implements ParserPage{
	
	private String siteName = "mebelluxe.com";
	
	public void saveProduct(String url, String anrexArticle) {
		OtherProduct otherProduct = new OtherProduct();
		MebelluxeCom mebelluxeCom = new MebelluxeCom();
		otherProduct.setUrl(url);
		otherProduct.setAnrexArticle(anrexArticle);
		otherProduct.setSateName(siteName);

		OtherProductService otherProductService = new OtherProductService();

		if (otherProductService.checkAnrexProductExist(otherProduct)) {
			otherProduct = otherProductService.getOtherProductByAnrexArticle(anrexArticle, otherProduct.getSateName());
			otherProduct.setUrl(url);
			otherProduct = mebelluxeCom.parseSitePage(otherProduct);
			otherProductService.updateOtherProduct(otherProduct);
		} else {
			otherProduct = mebelluxeCom.parseSitePage(otherProduct);
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
					.referrer("https://mebelluxe.com")
					.get();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Elements data = doc.select("h1");
		
		article = data.get(0).text();
		article = "mebelluxe.com";
		
		data = doc.select("h1");
		name = data.get(0).text();
		
		data = doc.select(".msoptionsprice-cost");
		String st = data.get(0).text();
		st = st.trim();
		priceActual = Integer.parseInt(st);
	
		try {

			data = doc.select(".old_price");
			st = data.get(0).text().replaceAll("\\s+", "");
			st = st.trim();
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
		MebelluxeCom mebelluxeCom = new MebelluxeCom();
		OtherProductService otherProductService = new OtherProductService();
		product = mebelluxeCom.parseSitePage(product);
		otherProductService.updateOtherProduct(product);
		
	}

}
