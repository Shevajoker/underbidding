package ru.underbidding.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.OtherProductService;

public class MebellinerRu implements ParserPage {

	public void saveProduct(String url, String anrexArticle) {
		OtherProduct otherProduct = new OtherProduct();
		MebellinerRu mebellinerRu = new MebellinerRu();
		otherProduct.setUrl(url);
		otherProduct.setAnrexArticle(anrexArticle);
		otherProduct.setSateName("mebelliner.ru");

		OtherProductService otherProductService = new OtherProductService();

		if (otherProductService.checkAnrexProductExist(otherProduct)) {
			otherProduct = otherProductService.getOtherProductByAnrexArticle(anrexArticle, otherProduct.getSateName());
			otherProduct.setUrl(url);
			otherProduct = mebellinerRu.parseSitePage(otherProduct);
			otherProductService.updateOtherProduct(otherProduct);
		} else {
			otherProduct = mebellinerRu.parseSitePage(otherProduct);
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
					.referrer("https://ekat-mebel.ru")
					.get();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Elements data = doc.select("h1");
		article = "111";

		data = doc.select("h1");
		name = data.get(0).text();


		data = doc.select(".card-price-current");
		String st = data.get(0).text();
		st = st.substring(0, st.length() - 8).trim();
		priceActual = Integer.parseInt(st);
		System.out.println(priceActual);

	
		try {

			data = doc.select(".card-price-old");
			st = data.get(0).text();
			st = st.substring(0, st.length() - 8).trim();
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
		product.setSateName("mebelliner.ru");

		return product;
	}

	public void updateProduct(OtherProduct product) {
		MebellinerRu mebellinerRu = new MebellinerRu();
		OtherProductService otherProductService = new OtherProductService();
		product = mebellinerRu.parseSitePage(product);
		otherProductService.updateOtherProduct(product);

	}

}
