package ru.underbidding.model;







import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "anrex_product")
public class AnrexProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "anrex_article")
	private String article;
	
	@Column(name = "price_actual")
	private int priceActual;
	
	@Column(name = "price_sale")
	private int priceSale;
	
	private String url;
	
//	@OneToMany(mappedBy = "anrexProduct", fetch = FetchType.LAZY, orphanRemoval = true)
//	private ArrayList<OtherProduct> otherProducts;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public int getPriceActual() {
		return priceActual;
	}

	public void setPriceActual(int priceActual) {
		this.priceActual = priceActual;
	}

	public int getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(int priceSale) {
		this.priceSale = priceSale;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	public ArrayList<OtherProduct> getOtherProducts() {
//		return otherProducts;
//	}
//
//	public void setOtherProducts(ArrayList<OtherProduct> list) {
//		this.otherProducts = list;
//	}

	@Override
	public String toString() {
		return "AnrexProduct [id=" + id + ", name=" + name + ", article=" + article + ", priceActual=" + priceActual
				+ ", priceSale=" + priceSale + ", url=" + url + "]";
	}

	

	
	
	
	

}
