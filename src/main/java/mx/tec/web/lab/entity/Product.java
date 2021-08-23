package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * Class that handles Products.
 * @author Cesar
 * 
 */
@Entity
public class Product implements Serializable {
	/**
	 * UID of Product, serialized.
	 */
	private static final long serialVersionUID = 1940424686731950240L;

	/**
	 * Product id.
	 */
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * Product name.
	 */
	private String name;
	
	/**
	 * Product description.
	 */
	private String description;
	
	/**
	 * Child sku list.
	 */
	@OneToMany(mappedBy = "parentProduct", cascade = CascadeType.ALL)
	private List<Sku> childSkus;

	/**
	 * No arguments constructor.
	 */
	public Product() {

	}

	/**
	 * Constructor including all Product properties.
	 * @param id
	 * @param name
	 * @param description
	 * @param largeImgUrl
	 * @param mediumImgUrl
	 * @param smallImgUrl
	 * @param childSkus
	 */
	public Product(long id, String name, String description, List<Sku> childSkus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.childSkus = childSkus;
	}

	/**
	 * Product id getter.
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Product id setter.
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Product name getter.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Product name setter.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Product description getter.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Product description setter.
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Product child skus list getter.
	 * @return the childSkus
	 */
	public List<Sku> getChildSkus() {
		return childSkus;
	}

	/**
	 * Product child skus list setter.
	 * @param childSkus the childSkus to set
	 */
	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}

	/**
	 * @return A string with all the properties of the Product
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", childSkus=" + childSkus
				+ "]";
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * @return True if the passed object is the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		return id == other.id;
	}

}
