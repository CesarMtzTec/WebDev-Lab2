package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Class that handles Skus.
 * @author Cesar
 *
 */
@Entity
public class Sku implements Serializable {
	/**
	 * UID of Sku, serialized.
	 */
	private static final long serialVersionUID = -6185764898853598449L;

	/**
	 * Sku id, automatically generated.
	 */
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * Sku color.
	 */
	private String color;
	
	/**
	 * Sku size.
	 */
	private String size;
	
	/**
	 * Sku list price.
	 */
	private double listPrice;
	
	/**
	 * Sku sale price.
	 */
	private double salePrice;
	
	/**
	 * Sku stock.
	 */
	private long quantityOnHand;
	
	/**
	 * Url string for the image (small)
	 */
	private String smallImageUrl;
	
	/**
	 * Url string for the image (medium)
	 */
	private String mediumImageUrl;
	
	/**
	 * Url string for the image (large)
	 */
	private String largeImageUrl;
	
	/**
	 * Parent product to which the Sku is related to in the database.
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Product parentProduct;

	
	/**
	 * No arguments constructor
	 */
	public Sku() {
	}

	/**
	 * Constructor including all Sku the properties
	 * @since 2.0
	 * @param id Sku id
	 * @param color Sku color
	 * @param size Sku size
	 * @param listPrice The list price
	 * @param salePrice The sale price
	 * @param quantityOnHand The quantity on hand
	 * @param smallImageUrl The small Image URL
	 * @param mediumImageUrl The medium Image URL
	 * @param largeImageUrl The large Image URL
	 */
	public Sku(long id, String color, String size, double listPrice, double salePrice, long quantityOnHand, String smallImageUrl, String mediumImageUrl, String largeImageUrl) {
		this.id = id;
		this.color = color;
		this.size = size;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
		this.quantityOnHand = quantityOnHand;
		this.smallImageUrl = smallImageUrl;
		this.mediumImageUrl = mediumImageUrl;
		this.largeImageUrl = largeImageUrl;
	}


	/**
	 * Id getter.
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Id setter.
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Color getter.
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * Color setter.
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Size getter.
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	
	/**
	 * Size setter.
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	/**
	 * List price getter.
	 * @return the listPrice
	 */
	public double getListPrice() {
		return listPrice;
	}
	
	/**
	 * List price setter.
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}
	
	/**
	 * Sale price getter.
	 * @return the salePrice
	 */
	public double getSalePrice() {
		return salePrice;
	}
	
	/**
	 * Sale price setter.
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	/**
	 * Stock getter.
	 * @return the quantityOnHand
	 */
	public long getQuantityOnHand() {
		return quantityOnHand;
	}
	
	/**
	 * Stock getter.
	 * @param quantityOnHand the quantityOnHand to set
	 */
	public void setQuantityOnHand(long quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	/**
	 * Small image url getter.
	 * @return the smallImageUrl
	 */
	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	/**
	 * Small image url setter.
	 * @param smallImageUrl the smallImageUrl to set
	 */
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	/**
	 * Medium image url getter.
	 * @return the mediumImageUrl
	 */
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}

	/**
	 * Medium image url setter.
	 * @param mediumImageUrl the mediumImageUrl to set
	 */
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}

	/**
	 * Large image url getter.
	 * @return the largeImageUrl
	 */
	public String getLargeImageUrl() {
		return largeImageUrl;
	}

	/**
	 * Large image url setter.
	 * @param largeImageUrl the largeImageUrl to set
	 */
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}

	/**
	 * Parent product getter.
	 * @return the parentProduct
	 */
	public Product getParentProduct() {
		return parentProduct;
	}

	/**
	 * Parent product setter.
	 * @param parentProduct the parentProduct to set
	 */
	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}

	/**
	 * @return A string with all the properties of the Sku
	 */
	@Override
	public String toString() {
		return "Sku [id=" + id + ", color=" + color + ", size=" + size + ", listPrice=" + listPrice + ", salePrice="
				+ salePrice + ", quantityOnHand=" + quantityOnHand + ", smallImageUrl=" + smallImageUrl
				+ ", mediumImageUrl=" + mediumImageUrl + ", largeImageUrl=" + largeImageUrl + ", parentProduct="
				+ parentProduct + "]";
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * @return True if the passed obj is the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sku)) {
			return false;
		}
		Sku other = (Sku) obj;
		return id == other.id;
	}
	
}
