package ar.com.ignacioflores.shoppingcart.service;

import java.util.List;
import java.io.Serializable;

import ar.com.ignacioflores.shoppingcart.domain.Product;

public interface ProductManager extends Serializable{

	public List<Product> getProducts();
}
