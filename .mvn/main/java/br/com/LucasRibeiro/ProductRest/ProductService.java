package br.com.LucasRibeiro.ProductRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public List<Product> listAll() {
		return repo.findAll();
	}

	public void save(Product p) {
		repo.save(p);
	}

	public void delete(Integer idProduct) {
		repo.deleteById(idProduct);

	}

	public Product get(Integer idProduct) {
		return repo.findById(idProduct).get();
	}

}
