package ar.com.ignacioflores.shoppingCart.service;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.ProductsForOfferId;

public interface ProductsForOfferIdService{

	public void addProductsForOfferId(ProductsForOfferId productsForOfferId);
    public void updateProductsForOfferId(ProductsForOfferId productsForOfferId);
    public List<ProductsForOfferId> listProductsForOfferIds();
    public ProductsForOfferId getProductsForOfferIdById(int productsForOfferIdId);
    public void removeProductsForOfferId(int productsForOfferIdId);	
}