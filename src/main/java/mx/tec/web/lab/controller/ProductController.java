/**
 * 
 */
package mx.tec.web.lab.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.web.lab.manager.ProductManager;
import mx.tec.web.lab.entity.Product;

/**
 * Class that handles all the REST api routes.
 * @author Cesar
 *
 */
@RestController
public class ProductController {
	/**
	 * ProductManager instance.
	 */
	@Resource
	private ProductManager productManager;

	/**
	 * The end point for GET {url}/products
	 * @return the list of products
	 */
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productManager.getProducts();
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	/**
	 * The end point for GET {url}/products/{id}
	 * @param id
	 * @return the product found with the id
	 */
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
	/**
	 * The end point for GET {url}/products?search={pattern}
	 * @param search Pattern to search
	 * @return a json list of all the products matching the pattern
	 */
	@GetMapping(value="/products", params="search")
	public ResponseEntity<List<Product>> getProducts(@RequestParam String search) {
		List<Product> products = productManager.getProducts(search);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	
	/**
	 * The end point for POST {url}/products
	 * @param newProduct
	 * @return the new product added
	 */
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
		ResponseEntity<Product> responseEntity;
		
		Product product = productManager.addProduct(newProduct);

		responseEntity = new ResponseEntity<>(product, HttpStatus.CREATED);
		
		return responseEntity;
	}
	
	/**
	 * The end point for PUT {url}/products/{id}
	 * @param id
	 * @param newProduct
	 * @return the updated product
	 */
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") long id, @RequestBody Product modifiedProduct) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			productManager.updateProduct(id, modifiedProduct);
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		
		return responseEntity;
	}

	
	/**
	 * The end point for DELETE {url}/products/delete/{id}
	 * @param id
	 * @return true if able to delete the product
	 */
	@DeleteMapping("/products/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity;
		
		Optional<Product> product = productManager.getProduct(id);
		
		if(product.isPresent()) {
			productManager.deleteProduct(product.get());
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;

	}
}

