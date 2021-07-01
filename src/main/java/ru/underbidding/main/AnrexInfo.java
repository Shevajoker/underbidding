package ru.underbidding.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.underbidding.model.AnrexProduct;
import ru.underbidding.service.AnrexProductService;

public class AnrexInfo {

	
	
	
	
	
	
	
	public void saveAnrexInfoProduct (String url) throws IOException {
		if (url != "") {
		AnrexProduct anrexProduct = new AnrexProduct();
		anrexProduct.setUrl(url);
		AnrexProductService anrexProductService =new AnrexProductService();
		anrexProductService.saveAnrexProduct(anrexProduct);
		AnrexInfo anrexInfo = new AnrexInfo();
		anrexProduct = anrexInfo.parseAnrexInfoPage(anrexProduct);
		anrexProductService.updateAnrexProduct(anrexProduct);
		}
	}

	public AnrexProduct parseAnrexInfoPage (AnrexProduct anrexProduct) throws IOException {
		String article;
		String name;
		int priceActual;
		int priceSale;
		String url = anrexProduct.getUrl();
		
		Document doc = Jsoup.connect(url)
				.userAgent("Chrome/4.0.249.0 Safari/532.5")
				.referrer("https://smebel.su")
				.get();
		
		Elements data = doc.select(".article").select(".value");
		article = data.get(0).text();
		
		data = doc.select("#pagetitle");
		name = data.get(0).text();
		
		data = doc.select(".price_value");
		String st = data.get(0).text().replaceAll("\\s+","");
		priceActual = Integer.parseInt(st);
		try {
		
			data = doc.select(".right_info").select(".discount").select(".price_value");
			st = data.get(0).text().replaceAll("\\s+","");
			priceSale = Integer.parseInt(st);
	
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No Sale!");
			System.out.print(e.getMessage());
			priceSale = 0;
		}
		anrexProduct.setArticle(article);
		anrexProduct.setName(name);
		anrexProduct.setPriceActual(priceActual);
		anrexProduct.setPriceSale(priceSale);
		return anrexProduct;
	}
	
}
