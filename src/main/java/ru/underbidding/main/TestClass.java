package ru.underbidding.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestClass {

	public static void main(String[] args) throws IOException, IndexOutOfBoundsException {

		String article;
		String name;
		int priceActual;
		int priceOld;

		String url = "https://planeta-komforta.com/catalog/mebel-dlya-spalni/shkafy-raspashnye/345372/?oid=345376";

//		String url = "http://xn--196-9cdtb6be2m.xn--p1acf/?price_id=23888";

//		url = URLEncoder.encode(url, "utf-8");
//		System.out.println(String.valueOf(url2));

		Document doc = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://google.ru/")
				.get();

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

//		
//		try {
//
//			data = doc.select(".product-item-detail-price-old");
////			st = data.get(0).text().replaceAll("\\s+", "");
////			st = data.get(0).text();
////			st = st.substring(0, st.length()-4).trim();
////			priceOld = Integer.parseInt(st);
////			priceOld = 0;
////			System.out.println(st);
//
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("No Sale!");
//			System.out.println(e.getMessage());
//			priceOld = 0;
//		}

//		System.out.println(priceOld + " - old");
//		System.out.println(priceActual + " - act");

//		String article;
//		String name;
//		int priceActual;
//		int priceSale;
//		String url = "https://anrex.info/catalog/gostinye/polki_nastennye/18447/";
//		
//		
//		Document doc = Jsoup.connect(url)
//				.userAgent("Chrome/4.0.249.0 Safari/532.5")
//				.referrer("https://smebel.su")
//				.get();
//		
//		Elements data = doc.select(".article").select(".value");
//		article = data.get(0).text();
//		
//		data = doc.select("#pagetitle");
//		name = data.get(0).text();
//		
//		data = doc.select(".price_value");
//		String st = data.get(0).text().replaceAll("\\s+","");
//		priceActual = Integer.parseInt(st);
//		
//		
//		
//		try {
//		
//			data = doc.select(".right_info").select(".discount").select(".price_value");
//			st = data.get(0).text().replaceAll("\\s+","");
//			priceSale = Integer.parseInt(st);
//			
////			System.out.println(data.get(0).text());
//			
//	
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("No Sale!");
//			System.out.print(e.getMessage());
//			priceSale = 0;
//		} 

//		AnrexProduct anrexProduct = new AnrexProduct();
//		anrexProduct.setArticle(article);
//		anrexProduct.setName(name);
//		anrexProduct.setPriceActual(priceActual);
//		anrexProduct.setPriceSale(priceSale);
//		anrexProduct.setUrl(url);
//		
//		System.out.println(anrexProduct.toString());
//		System.out.println("###############");
//		
//		AnrexProductService anrexService = new AnrexProductService();
//		anrexService.saveAnrexProduct(anrexProduct);

//		AnrexInfo anrexInfo = new AnrexInfo();
//		anrexInfo.saveAnrexInfoProduct("https://anrex.info/catalog/gostinye/zhurnalnye_stoly/18550/");
//		

//		
//		for (Element element : data) {
//			System.out.println(element.text());
//		}
//		
//		
//		System.out.println("_____________");

//		System.out.println(data.get(0).text());

//		AnrexProduct anrexProduct = new AnrexProduct();
//		anrexProduct.setArticle("646098");
//		anrexProduct.setName("?????????????? 45, OSKAR , ???????? ?????? ??????????????");
//		anrexProduct.setPriceActual(5799);
//		anrexProduct.setPriceSale(0);
//		anrexProduct.setUrl("https://anrex.info/catalog/prikhozhie/veshalki/18460/");
//		
//		
//		
//		
//		OtherProduct otherProduct = new OtherProduct();
//		otherProduct.setArticle("1111");
//		otherProduct.setName("Name Other");
//		otherProduct.setPriceActual(10);
//		otherProduct.setPriceSale(5);
//		otherProduct.setUrl("https://smebel.su/prihozhaya/veshalki-v-prihozhuyu/veshalka-byork-olha-polyarnaya-oniks");
//		otherProduct.setAnrexAricle("55555");
////		ArrayList<OtherProduct> list = new ArrayList<OtherProduct>();
////		list.add(otherProduct);
////		anrexProduct.setOtherProducts(list);
//		
//		AnrexProductService anrexService = new AnrexProductService();
//		anrexService.saveAnrexProduct(anrexProduct);
//		
////		OtherProductService otherService = new OtherProductService();
////		otherService.saveOtherProduct(otherProduct);
//		
//		
//		System.out.println(otherProduct.toString());
//		System.out.println("###################");
//		System.out.println(anrexProduct.toString());

	}

}
