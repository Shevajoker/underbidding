package ru.underbidding.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.OtherProductService;

public class EkatMebelRu implements ParserPage {

	public void saveProduct(String url, String anrexArticle) {

		OtherProduct otherProduct = new OtherProduct();
		EkatMebelRu ekatMebelRu = new EkatMebelRu();
		otherProduct.setUrl(url);
		otherProduct.setAnrexArticle(anrexArticle);
		otherProduct.setSateName("ekat-mebel.ru");

		OtherProductService otherProductService = new OtherProductService();

		if (otherProductService.checkAnrexProductExist(otherProduct)) {
			otherProduct = otherProductService.getOtherProductByAnrexArticle(anrexArticle, otherProduct.getSateName());
			otherProduct.setUrl(url);
			otherProduct = ekatMebelRu.parseSitePage(otherProduct);
			otherProductService.updateOtherProduct(otherProduct);
		} else {
			otherProduct = ekatMebelRu.parseSitePage(otherProduct);
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
			System.out.println("--Ecxeption-- parseSitePage - URL - ERROR - Jsoup.connect --");
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}

		Elements data = doc.select("h1");
		article = data.get(0).text();
		System.out.println(data.get(0).text());

		data = doc.select("h1");
		name = data.get(0).text();
		System.out.println(data.get(0).text());

		data = doc.select("strong");
		String st = data.get(3).text();
		st = st.substring(0, st.length() - 4).trim();
		priceActual = Integer.parseInt(st);
		System.out.println(priceActual);

		try {

			data = doc.select(".p-price-block").select(".price-old");
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
		product.setSateName("ekat-mebel.ru");

		return product;
	}

	public void updateProduct(OtherProduct product) {
		EkatMebelRu ekatMebelRu = new EkatMebelRu();
		OtherProductService otherProductService = new OtherProductService();
		product = ekatMebelRu.parseSitePage(product);
		otherProductService.updateOtherProduct(product);
	}

}
