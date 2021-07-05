package ru.underbidding.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "price_old")
	private int priceOld;
	
	private String url;


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
		return priceOld;
	}

	public void setpriceOld(int priceOld) {
		this.priceOld = priceOld;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "AnrexProduct [id=" + id + ", name=" + name + ", article=" + article + ", priceActual=" + priceActual
				+ ", priceSale=" + priceOld + ", url=" + url + "]";
	}

	

	
	
	
	

}
