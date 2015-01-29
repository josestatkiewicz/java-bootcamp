package ar.com.ignacioflores.shoppingcart.service;

import java.util.List;

import ar.com.ignacioflores.shoppingcart.domain.Product;

public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    private List<Product> products;

    public List<Product> getProducts() {
        return products; 
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
