package ru.underbidding.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.OtherProductService;

public class MargomebelMskRu implements ParserPage{
	private String siteName = "margomebel-msk.ru";
	
	public void saveProduct(String url, String anrexArticle) {
		OtherProduct otherProduct = new OtherProduct();
		MargomebelMskRu margomebelMskRu = new MargomebelMskRu();
		otherProduct.setUrl(url);
		otherProduct.setAnrexArticle(anrexArticle);
		otherProduct.setSateName(siteName);

		OtherProductService otherProductService = new OtherProductService();

		if (otherProductService.checkAnrexProductExist(otherProduct)) {
			otherProduct = otherProductService.getOtherProductByAnrexArticle(anrexArticle, otherProduct.getSateName());
			otherProduct.setUrl(url);
			otherProduct = margomebelMskRu.parseSitePage(otherProduct);
			otherProductService.updateOtherProduct(otherProduct);
		} else {
			otherProduct = margomebelMskRu.parseSitePage(otherProduct);
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

		Elements data = doc.select(".manufacture-logo");
		
		article = data.get(0).text();	
		
		data = doc.select(".name");
		name = data.get(0).text();

		
		data = doc.select(".price");
		String st = data.get(0).text();
		st = st.replaceAll("\\s+", "");
		st = st.substring(0, st.length()-1).trim();
		priceActual = Integer.parseInt(st);
		
		try {
			priceOld = 0;
			System.out.println(st);

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
		MargomebelMskRu margomebelMskRu = new MargomebelMskRu();
		OtherProductService otherProductService = new OtherProductService();
		product = margomebelMskRu.parseSitePage(product);
		otherProductService.updateOtherProduct(product);
		
	}

}
