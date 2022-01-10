package br.com.LucasRibeiro.ProductRest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer idProduct;
	private String name;
	private float price;

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product(Integer idProduct, String name, float price) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
