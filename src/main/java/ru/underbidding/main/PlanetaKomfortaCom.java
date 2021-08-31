package ru.underbidding.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.OtherProductService;

public class PlanetaKomfortaCom implements ParserPage{
	private String siteName = "planeta-komforta.com";

	public void saveProduct(String url, String anrexArticle) {
		OtherProduct otherProduct = new OtherProduct();
		PlanetaKomfortaCom planetaKomfortaCom = new PlanetaKomfortaCom();
		otherProduct.setUrl(url);
		otherProduct.setAnrexArticle(anrexArticle);
		otherProduct.setSateName(siteName);

		OtherProductService otherProductService = new OtherProductService();

		if (otherProductService.checkAnrexProductExist(otherProduct)) {
			otherProduct = otherProductService.getOtherProductByAnrexArticle(anrexArticle, otherProduct.getSateName());
			otherProduct.setUrl(url);
			otherProduct = planetaKomfortaCom.parseSitePage(otherProduct);
			otherProductService.updateOtherProduct(otherProduct);
		} else {
			otherProduct = planetaKomfortaCom.parseSitePage(otherProduct);
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
			doc = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://google.ru/")
					.get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Elements data = doc.select(".bx-breadcrumb-item--mobile");

		article = "planeta-komforta.com";
		System.out.println(article);

		data = doc.select("h1");
		name = data.get(data.size() - 1).text();
		System.out.println("name " + name);

		data = doc.select(".prices_block").select(".values_wrapper");
		String st = data.html();
		st = st.replaceAll("\\s+", "");
		st = st.substring(0, st.length() - 4).trim();
		priceActual = Integer.parseInt(st);
		priceOld = 0;
		
		product.setArticle(article);
		product.setName(name);
		product.setPriceActual(priceActual);
		product.setPriceOld(priceOld);
		product.setSateName(siteName);
		return product;
		
	}

	public void updateProduct(OtherProduct product) {
		PlanetaKomfortaCom planetaKomfortaCom = new PlanetaKomfortaCom();
		OtherProductService otherProductService = new OtherProductService();
		product = planetaKomfortaCom.parseSitePage(product);
		otherProductService.updateOtherProduct(product);
		
	}

}
