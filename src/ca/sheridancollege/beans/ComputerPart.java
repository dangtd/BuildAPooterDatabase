package ca.sheridancollege.beans;

import java.io.Serializable;

public class ComputerPart implements Serializable {
	
	private String title, partName, smallImage, mediumImage, largeImage, aSIN, price, numPrice;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public String getMediumImage() {
		return mediumImage;
	}

	public void setMediumImage(String mediumImage) {
		this.mediumImage = mediumImage;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	

	public String getaSIN() {
		return aSIN;
	}

	public void setaSIN(String aSIN) {
		this.aSIN = aSIN;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNumPrice() {
		return numPrice;
	}

	public void setNumPrice(String numPrice) {
		this.numPrice = numPrice;
	}
}
