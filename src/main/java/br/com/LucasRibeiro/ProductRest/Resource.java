package br.com.LucasRibeiro.ProductRest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {

	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public List<Product> list() {
		return service.listAll();
	}

	@GetMapping("/products/{idProduct}")
	public ResponseEntity<Product> get(@PathVariable Integer idProduct) {
		try {
			Product product = service.get(idProduct);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

		}

	}

	@PostMapping("/product/save")
	public void add(@RequestBody Product product) {
		service.save(product);

	}

	@PutMapping("/product/update/{idProduct}")
	public ResponseEntity<?> update(@RequestBody Product p, @PathVariable Integer idProduct) {
		try {
			Product existProduct = service.get(idProduct);
			existProduct.setName(p.getName());
			existProduct.setPrice(p.getPrice());
			service.save(existProduct);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
		@DeleteMapping("/product/delete/{idProduct}")
		public void delete(@PathVariable Integer idProduct) {
			service.delete(idProduct);
		}
		
	}


