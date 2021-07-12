package ru.underbidding.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.OtherProductService;

public class SmebelSu {


	
	public void saveSmebelProduct(String url, String anrexArticle) throws IOException {
		OtherProduct otherProduct = new OtherProduct();
		SmebelSu smebelSu = new SmebelSu();
		otherProduct.setUrl(url);
		otherProduct.setAnrexArticle(anrexArticle);
		otherProduct.setSateName("smebel.su");
		
		OtherProductService otherProductService = new OtherProductService();
		
		if (otherProductService.checkAnrexProductExist(otherProduct)) {
			otherProduct = otherProductService.getOtherProductByAnrexArticle(anrexArticle, otherProduct.getSateName());
			otherProduct.setUrl(url);
			otherProduct = smebelSu.parseSmebelSuPage(otherProduct);
			otherProductService.updateOtherProduct(otherProduct);
		} else {
			otherProduct = smebelSu.parseSmebelSuPage(otherProduct);
			otherProductService.saveOtherProduct(otherProduct);
		}
		
	}
	
	public OtherProduct parseSmebelSuPage(OtherProduct otherProduct) throws IOException {
		
		String article;
		String name;
		int priceActual;
		int priceOld;
		
		String url = otherProduct.getUrl();
		

		Document doc = Jsoup.connect(url)
				.userAgent("Chrome/4.0.249.0 Safari/532.5")
				.referrer("https://smebel.su")
				.get();

		Elements data = doc.select(".product-model");
		article = data.get(0).text();

		data = doc.select(".product-title");
		name = data.get(0).text();

		data = doc.select(".formated_price");
		String st = data.get(0).text().replaceAll("\\s+", "");
		st = st.substring(0, st.length()-4);
		priceActual = Integer.parseInt(st);
		try {

			data = doc.select(".p-price-block").select(".price-old");
			st = data.get(0).text().replaceAll("\\s+", "");
			priceOld = Integer.parseInt(st);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("No Sale!");
			System.out.println(e.getMessage());
			priceOld = 0;
		}
		otherProduct.setArticle(article);
		otherProduct.setName(name);
		otherProduct.setPriceActual(priceActual);
		otherProduct.setPriceOld(priceOld);
		otherProduct.setSateName("smebel.su");
		System.out.println(otherProduct.toString());
		return otherProduct;
		
	}
	
	public void updateSmebelSuProduct(OtherProduct product) throws IOException {
		SmebelSu smebelSu = new SmebelSu();
		OtherProductService otherProductService = new OtherProductService();
		
		product = smebelSu.parseSmebelSuPage(product);
		otherProductService.updateOtherProduct(product);
		
	}
	
	
}
