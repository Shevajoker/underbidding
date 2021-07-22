package ru.underbidding.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ru.underbidding.model.AnrexProduct;
import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.AnrexProductService;
import ru.underbidding.service.OtherProductService;

public class TestClass {


	
	
	public static void main(String[] args) throws IOException, IndexOutOfBoundsException {
		
		
			
		String article;
		String name;
		int priceActual;
		int priceOld;
		
		String url = "https://techshop.ru/product/anrex-oskar-1dm-dub-sanremo/";
		

		Document doc = Jsoup.connect(url)
				.userAgent("Chrome/4.0.249.0 Safari/532.5")
				.referrer("https://mebelluxe.com")
				.get();

		Elements data = doc.select(".element-code");
		
		article = data.get(0).text();
//		article = "techshop.ru";
		System.out.println(article);
		
		
		
		data = doc.select("h1");
		name = data.get(0).text();
		System.out.println(name);
		
		
		
		
		data = doc.select(".price");
		String st = data.get(0).text();
		st = st.replaceAll("\\s+", "");
//		st = st.replaceAll("\\s+", "");
		st = st.substring(5, st.length()-4).trim();
		priceActual = Integer.parseInt(st);
		System.out.println(st);

//		
		try {

			data = doc.select(".goods-old-price");
			st = data.get(0).text().replaceAll("\\s+", "");
//			st = data.get(0).text();
			st = st.substring(0, st.length()-4).trim();
			priceOld = Integer.parseInt(st);
			System.out.println(st);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("No Sale!");
			System.out.println(e.getMessage());
			priceOld = 0;
		}
		
		System.out.println(priceOld + " - old");
		System.out.println(priceActual + " - act");
		
		
		
		
		
		
		
		
		
		
		
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
//		anrexProduct.setName("Вешалка 45, OSKAR , цвет дуб Санремо");
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
