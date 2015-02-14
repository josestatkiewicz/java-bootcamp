package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ShoppingCartDAO;
import ar.com.ignacioflores.shoppingCart.model.ShoppingCart;
import ar.com.ignacioflores.shoppingCart.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ShoppingCartDAO shoppingCartDAO;

	public void setShoppingCartDAO(ShoppingCartDAO shoppingCartDAO) {
		this.shoppingCartDAO = shoppingCartDAO;
	}

	@Override
	@Transactional
	public void addShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCartDAO.addShoppingCart(shoppingCart);
	}

	@Override
	@Transactional
	public void updateShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCartDAO.updateShoppingCart(shoppingCart);
	}

	@Override
	@Transactional
	public List<ShoppingCart> listShoppingCarts() {
		return this.shoppingCartDAO.listShoppingCarts();
	}

	@Override
	@Transactional
	public ShoppingCart getShoppingCartById(int id) {
		return this.shoppingCartDAO.getShoppingCartById(id);
	}

	@Override
	@Transactional
	public void removeShoppingCart(int id) {
		this.shoppingCartDAO.removeShoppingCart(id);
	}

	@Override
	public double performDiscountCreditCard(Integer shoppingCartId) {
		ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCartById(shoppingCartId);
		double res = shoppingCart.getAmount() * 0.1;
		return res;
	}

	@Override
	public double performDiscountPayPal(Integer shoppingCartId) {
		double res = shoppingCartDAO.getCheapestProduct(shoppingCartId).getPrice();
		return res;
	}

	@Override
	public double performDiscountCash(Integer shoppingCartId) {
		double res = shoppingCartDAO.getMostExpensiveProduct(shoppingCartId).getPrice() * 0.9;
		return res;
	}

}