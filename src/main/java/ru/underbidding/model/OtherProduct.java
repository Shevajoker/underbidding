package ru.underbidding.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "other_product")
public class OtherProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "article")
	private String article;
	
	@Column(name = "price_actual")
	private int priceActual;
	
	@Column(name = "price_old")
	private int priceOld;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "anrex_article")
	private String anrexArticle; 
	
	@Column(name="site_name")
	private String sateName;

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

	public int getPriceOld() {
		return priceOld;
	}

	public void setPriceOld(int priceOld) {
		this.priceOld = priceOld;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAnrexArticle() {
		return anrexArticle;
	}

	public void setAnrexArticle(String anrexArticle) {
		this.anrexArticle = anrexArticle;
	}

	public String getSateName() {
		return sateName;
	}

	public void setSateName(String sateName) {
		this.sateName = sateName;
	}



	@Override
	public String toString() {
		return "OtherProduct [id=" + id + ", name=" + name + ", article=" + article + ", priceActual=" + priceActual
				+ ", priceOld=" + priceOld + ", url=" + url + ", anrexArticle=" + anrexArticle + ", sateName="
				+ sateName + "]";
	} 
	
	

	
	
	
}
