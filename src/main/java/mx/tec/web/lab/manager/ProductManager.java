/**
 * 
 */
package mx.tec.web.lab.manager;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.tec.web.lab.entity.Product;
import mx.tec.web.lab.entity.Sku;
import mx.tec.web.lab.repository.ProductRepository;


/**
 * Class that handles Product-related operations with the ProductRepository.
 * @author Cesar
 *
 */
@Service
public class ProductManager {
	/**
	 * Product repository instance.
	 */
	@Resource
	ProductRepository productRepository;
	
	/**
	 * Retrieve all the products from the repository.
	 * @return List of products
	 */
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	
	/**
	 * Retrieve a product with an id from the repository.
	 * @param id
	 * @return the product found
	 */
	public Optional<Product> getProduct(final long id) {		
		return productRepository.findById(id);
	}
	
	/**
	 * Retrieve a specific product based on a given product id from the repository.
	 * @param pattern Pattern to search
	 * @return Optional containing a product if the product was found or empty otherwise
	 */
	public List<mx.tec.web.lab.entity.Product> getProducts(final String pattern) {
		return productRepository.findByNameLike(pattern);
	}

	
	/**
	 * Add a Product to the repository.
	 * @param newProduct
	 * @return the new product
	 */
	public Product addProduct(final Product newProduct) {
		for (final Sku newSku : newProduct.getChildSkus()) {
			newSku.setParentProduct(newProduct);
		}
		
		return productRepository.save(newProduct);
	}
	
	/**
	 * Update a Product already on the repository.
	 * @param oldProduct
	 * @param newProduct
	 * @return the updated product
	 */
	public void updateProduct(final long id, final Product modifiedProduct) {
		if(modifiedProduct.getId() == id) {
			for (final Sku modifiedSku : modifiedProduct.getChildSkus()) {
				modifiedSku.setParentProduct(modifiedProduct);
			}
			productRepository.save(modifiedProduct);
		}
	}
	
	/**
	 * Delete a Product from the repository.
	 * @param product
	 * @return true if able to remove the product
	 */
	public void deleteProduct(final Product product) {
		productRepository.delete(product);
	}

}
