package ar.com.ignacioflores.shoppingCart.dao;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.Product;

public interface ProductDAO {

	public void addProduct(Product product);
    public void updateProduct(Product product);
    public List<Product> listProducts();
    public Product getProductById(int productId);
    public void removeProduct(int productId);
    public List<Product> findProductsByCategory(String category);
    public List<Product> findProductsByName(String name);
}
