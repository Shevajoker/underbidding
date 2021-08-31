package ru.underbidding.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.OtherProductService;

public class MebelfonRu implements ParserPage {
	private String siteName = "mebelfon.ru";

	public void saveProduct(String url, String anrexArticle) {
		OtherProduct otherProduct = new OtherProduct();
		MebelfonRu mebelfonRu = new MebelfonRu();
		otherProduct.setUrl(url);
		otherProduct.setAnrexArticle(anrexArticle);
		otherProduct.setSateName(siteName);

		OtherProductService otherProductService = new OtherProductService();

		if (otherProductService.checkAnrexProductExist(otherProduct)) {
			otherProduct = otherProductService.getOtherProductByAnrexArticle(anrexArticle, otherProduct.getSateName());
			otherProduct.setUrl(url);
			otherProduct = mebelfonRu.parseSitePage(otherProduct);
			otherProductService.updateOtherProduct(otherProduct);
		} else {
			otherProduct = mebelfonRu.parseSitePage(otherProduct);
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
			doc = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("https://mebelfon.ru").get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Elements data = doc.select("#pagetitle");

//		article = data.get(0).text();
		article = "mebelfon.ru";

		data = doc.select("#pagetitle");
		name = data.get(0).text();

		data = doc.select(".product-item-detail-price-current");
		String st = data.get(0).text();
		st = st.replaceAll("\\s+", "");
		st = st.substring(0, st.length() - 1).trim();
		priceActual = Integer.parseInt(st);

		try {

			data = doc.select(".product-item-detail-price-old");
			st = data.get(0).text().replaceAll("\\s+", "");
			st = data.get(0).text();
			st = st.substring(0, st.length() - 4).trim();
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
		MebelfonRu mebelfonRu = new MebelfonRu();
		OtherProductService otherProductService = new OtherProductService();
		product = mebelfonRu.parseSitePage(product);
		otherProductService.updateOtherProduct(product);

	}

}
