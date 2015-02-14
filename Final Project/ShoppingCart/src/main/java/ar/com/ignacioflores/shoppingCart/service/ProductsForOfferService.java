package ar.com.ignacioflores.shoppingCart.service;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.ProductsForOffer;

public interface ProductsForOfferService{

	public void addProductsForOffer(ProductsForOffer productsForOffer);
    public void updateProductsForOffer(ProductsForOffer productsForOffer);
    public List<ProductsForOffer> listProductsForOffers();
    public ProductsForOffer getProductsForOfferById(int productsForOfferId);
    public void removeProductsForOffer(int productsForOfferId);
}