package ru.underbidding.model;

public class ShowTable {
	
	private String articleNumber;
	private String nameProduct;
	private int priceActualAnrexProduct;
	private int priceActualOtherProduct;
	private int priceOldAnrexProduct;
	private int priceOldOtherProduct;
	private String urlAnrexProduct;
	private String urlOtherProduct;
	
	public ShowTable() {
	
	}

	public ShowTable(String articleNumber, String nameProduct, int priceActualAnrexProduct, int priceActualOtherProduct,
			int priceOldAnrexProduct, int priceOldOtherProduct,String urlAnrexProduct, String urlOtherProduct) {
		super();
		this.articleNumber = articleNumber;
		this.nameProduct = nameProduct;
		this.priceActualAnrexProduct = priceActualAnrexProduct;
		this.priceActualOtherProduct = priceActualOtherProduct;
		this.priceOldAnrexProduct = priceOldAnrexProduct;
		this.priceOldOtherProduct = priceOldOtherProduct;
		this.urlAnrexProduct = urlAnrexProduct;
		this.urlOtherProduct = urlOtherProduct;
	}

	public String getUrlAnrexProduct() {
		return urlAnrexProduct;
	}

	public void setUrlAnrexProduct(String urlAnrexProduct) {
		this.urlAnrexProduct = urlAnrexProduct;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getPriceActualAnrexProduct() {
		return priceActualAnrexProduct;
	}

	public void setPriceActualAnrexProduct(int priceActualAnrexProduct) {
		this.priceActualAnrexProduct = priceActualAnrexProduct;
	}

	public int getPriceActualOtherProduct() {
		return priceActualOtherProduct;
	}

	public void setPriceActualOtherProduct(int priceActualOtherProduct) {
		this.priceActualOtherProduct = priceActualOtherProduct;
	}

	public int getPriceOldAnrexProduct() {
		return priceOldAnrexProduct;
	}

	public void setPriceOldAnrexProduct(int priceOldAnrexProduct) {
		this.priceOldAnrexProduct = priceOldAnrexProduct;
	}

	public int getPriceOldOtherProduct() {
		return priceOldOtherProduct;
	}

	public void setPriceOldOtherProduct(int priceOldOtherProduct) {
		this.priceOldOtherProduct = priceOldOtherProduct;
	}

	public String getUrlOtherProduct() {
		return urlOtherProduct;
	}

	public void setUrlOtherProduct(String urlOtherProduct) {
		this.urlOtherProduct = urlOtherProduct;
	}

	@Override
	public String toString() {
		return "ShowTable [articleNumber=" + articleNumber + ", nameProduct=" + nameProduct
				+ ", priceActualAnrexProduct=" + priceActualAnrexProduct + ", priceActualOtherProduct="
				+ priceActualOtherProduct + ", priceOldAnrexProduct=" + priceOldAnrexProduct + ", priceOldOtherProduct="
				+ priceOldOtherProduct + ", urlAnrexProduct=" + urlAnrexProduct + ", urlOtherProduct=" + urlOtherProduct
				+ "]";
	}

	

	
	
}
