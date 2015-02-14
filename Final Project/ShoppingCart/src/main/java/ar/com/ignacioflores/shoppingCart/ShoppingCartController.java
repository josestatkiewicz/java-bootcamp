package ar.com.ignacioflores.shoppingCart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.ignacioflores.shoppingCart.model.Offer;
import ar.com.ignacioflores.shoppingCart.model.OfferForShoppingCart;
import ar.com.ignacioflores.shoppingCart.model.OfferForShoppingCartId;
import ar.com.ignacioflores.shoppingCart.model.PayOrder;
import ar.com.ignacioflores.shoppingCart.model.Payment;
import ar.com.ignacioflores.shoppingCart.model.Product;
import ar.com.ignacioflores.shoppingCart.model.ProductsForShoppingCart;
import ar.com.ignacioflores.shoppingCart.model.ProductsForShoppingCartId;
import ar.com.ignacioflores.shoppingCart.model.ShoppingCart;
import ar.com.ignacioflores.shoppingCart.model.User;
import ar.com.ignacioflores.shoppingCart.service.OfferForShoppingCartService;
import ar.com.ignacioflores.shoppingCart.service.OfferService;
import ar.com.ignacioflores.shoppingCart.service.PayOrderService;
import ar.com.ignacioflores.shoppingCart.service.PaymentService;
import ar.com.ignacioflores.shoppingCart.service.ProductService;
import ar.com.ignacioflores.shoppingCart.service.ProductsForShoppingCartService;
import ar.com.ignacioflores.shoppingCart.service.ShoppingCartService;
import ar.com.ignacioflores.shoppingCart.service.UserService;

@Controller
public class ShoppingCartController {

	private UserService userService;
	private ShoppingCartService shoppingCartService;
	private ProductsForShoppingCartService productsForShoppingCartService;
	private ProductService productService;
	private OfferForShoppingCartService offerForShoppingCartService;
	private OfferService offerService;
	private PayOrderService payOrderService;
	private PaymentService paymentService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired(required = true)
	@Qualifier(value = "shoppingCartService")
	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	@Autowired(required = true)
	@Qualifier(value = "productsForShoppingCartService")
	public void setProductsForShoppingCartService(
			ProductsForShoppingCartService productsForShoppingCartService) {
		this.productsForShoppingCartService = productsForShoppingCartService;
	}

	@Autowired(required = true)
	@Qualifier(value = "productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired(required = true)
	@Qualifier(value = "offerForShoppingCartService")
	public void setOfferForShoppingCartService(
			OfferForShoppingCartService offerForShoppingCartService) {
		this.offerForShoppingCartService = offerForShoppingCartService;
	}

	@Autowired(required = true)
	@Qualifier(value = "offerService")
	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}

	@Autowired(required = true)
	@Qualifier(value = "payOrderService")
	public void setPayOrderService(PayOrderService payOrderService) {
		this.payOrderService = payOrderService;
	}

	@Autowired(required = true)
	@Qualifier(value = "paymentService")
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public @ResponseBody String addUser(@ModelAttribute User user) {

		user.setState("Active");
		userService.addUser(user);

		return "user added: \n" + user.toString() + "\n" + "plese login: ";
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public @ResponseBody String getUser(@PathVariable("userId") Integer userId) {
		User user = userService.getUserById(userId);
		return user.toString();
	}

	@RequestMapping(value = "/users/{userId}/buy", method = RequestMethod.POST)
	public @ResponseBody String addShoppingCart(
			@PathVariable("userId") Integer userId) {
		ShoppingCart shoppingCart = new ShoppingCart();
		float amount = 0;
		User user = userService.getUserById(userId);
		shoppingCart.setAmount(amount);
		shoppingCart.setUser(user);
		shoppingCartService.addShoppingCart(shoppingCart);
		return "Shopping Cart added: \n"
				+ shoppingCartService.getShoppingCartById(
						shoppingCart.getIdShoppingCart()).toString();
	}

	@RequestMapping(value = "/users/{userId}/buy/{shoppingCartId}", method = RequestMethod.GET)
	public @ResponseBody String getShoppingCart(
			@PathVariable("userId") Integer userId,
			@PathVariable("shoppingCartId") Integer shoppingCartId) {
		ShoppingCart shoppingCart = shoppingCartService
				.getShoppingCartById(shoppingCartId);
		return shoppingCart.toString();
	}

	@RequestMapping(value = "/users/{userId}/buy/{shoppingCartId}/addProduct", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public @ResponseBody String addProductToShoppingCart(
			@PathVariable("userId") Integer userId,
			@PathVariable("shoppingCartId") Integer shoppingCartId,
			@ModelAttribute("productId") Integer productId,
			@ModelAttribute("quantity") Integer quantity) {
		Product product = productService.getProductById(productId);
		ShoppingCart shoppingCart = shoppingCartService
				.getShoppingCartById(shoppingCartId);
		ProductsForShoppingCartId productsForShoppingCartId = new ProductsForShoppingCartId();
		productsForShoppingCartId.setProduct(productId);
		productsForShoppingCartId.setShoppingCart(shoppingCartId);
		ProductsForShoppingCart productsForShoppingCart = new ProductsForShoppingCart();
		productsForShoppingCart.setId(productsForShoppingCartId);
		productsForShoppingCart.setProduct(product);
		productsForShoppingCart.setShoppingCart(shoppingCart);
		productsForShoppingCart.setQuantity(quantity);
		productsForShoppingCartService
				.addProductsForShoppingCart(productsForShoppingCart);
		return "Item added to shopping cart: \n"
				+ productsForShoppingCart.toString();
	}

	@RequestMapping(value = "/users/{userId}/buy/{shoppingCartId}/addOffer", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public @ResponseBody String addOfferToShoppingCart(
			@PathVariable("userId") Integer userId,
			@PathVariable("shoppingCartId") Integer shoppingCartId,
			@ModelAttribute("offerId") Integer offerId,
			@ModelAttribute("quantity") Integer quantity) {
		Offer offer = offerService.getOfferById(offerId);
		ShoppingCart shoppingCart = shoppingCartService
				.getShoppingCartById(shoppingCartId);
		OfferForShoppingCartId offerForShoppingCartId = new OfferForShoppingCartId();
		offerForShoppingCartId.setOffer(offerId);
		offerForShoppingCartId.setShoppingCart(shoppingCartId);
		OfferForShoppingCart offerForShoppingCart = new OfferForShoppingCart();
		offerForShoppingCart.setId(offerForShoppingCartId);
		offerForShoppingCart.setOffer(offer);
		offerForShoppingCart.setShoppingCart(shoppingCart);
		offerForShoppingCart.setQuantity(quantity);

		offerForShoppingCartService
				.addOfferForShoppingCart(offerForShoppingCart);
		return "Item added to shopping cart: \n"
				+ offerForShoppingCart.toString();
	}

	@RequestMapping(value = "/users/{userId}/buy/{shoppingCartId}/ok", method = RequestMethod.POST)
	public @ResponseBody String generatePayOrder(
			@PathVariable("userId") Integer userId,
			@PathVariable("shoppingCartId") Integer shoppingCartId) {
		PayOrder payOrder = new PayOrder();
		ShoppingCart shoppingCart = shoppingCartService
				.getShoppingCartById(shoppingCartId);
		payOrder.setShoppingCart(shoppingCart);
		payOrder.setDiscount("0");
		payOrder.setPayStatus("Pending");
		shoppingCart.setShoppingCartStatus("Hold");
		shoppingCartService.updateShoppingCart(shoppingCart);
		payOrderService.addPayOrder(payOrder);
		return "Pay Order created: \n" + payOrder.toString();
	}

	@RequestMapping(value = "/users/{userId}/buy/{shoppingCartId}/payOrder/{payOrderId}", method = RequestMethod.GET)
	public @ResponseBody String getPayOrder(
			@PathVariable("userId") Integer userId,
			@PathVariable("shoppingCartId") Integer shoppingCartId,
			@PathVariable("payOrderId") Integer payOrderId) {
		PayOrder payOrder = payOrderService.getPayOrderById(payOrderId);
		return payOrder.toString();
	}

	@RequestMapping(value = "/users/{userId}/buy/{shoppingCartId}/payOrder/{payOrderId}/payCash", method = RequestMethod.POST)
	public @ResponseBody String PayWithCash(
			@PathVariable("userId") Integer userId,
			@PathVariable("shoppingCartId") Integer shoppingCartId,
			@PathVariable("payOrderId") Integer payOrderId) {
		PayOrder payOrder = payOrderService.getPayOrderById(payOrderId);
		double discountD = shoppingCartService
				.performDiscountCash(shoppingCartId);
		String discount = String.valueOf(discountD);
		payOrder.setDiscount(discount);
		payOrder.setPayStatus("Paid");
		payOrder.setPrice((float) (payOrder.getPrice() - discountD));
		payOrderService.updatePayOrder(payOrder);
		Payment payment = new Payment();
		payment.setAmount(payOrder.getPrice());
		payment.setPayOrder(payOrder);
		payment.setPaymentType("Cash");
		paymentService.addPayment(payment);
		return "Successful cash payment, details: \n" + payOrder.toString();
	}

	@RequestMapping(value = "/users/{userId}/buy/{shoppingCartId}/payOrder/{payOrderId}/payCreditCard", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public @ResponseBody String PayWithCreditCard(
			@PathVariable("userId") Integer userId,
			@PathVariable("shoppingCartId") Integer shoppingCartId,
			@PathVariable("payOrderId") Integer payOrderId,
			@ModelAttribute("name") String name,
			@ModelAttribute("CCNumber") String ccNumber) {
		PayOrder payOrder = payOrderService.getPayOrderById(payOrderId);
		double discountD = shoppingCartService
				.performDiscountCreditCard(shoppingCartId);
		String discount = String.valueOf(discountD);
		payOrder.setDiscount(discount);
		payOrder.setPayStatus("Paid");
		payOrder.setPrice((float) (payOrder.getPrice() - discountD));
		payOrderService.updatePayOrder(payOrder);
		Payment payment = new Payment();
		payment.setAmount(payOrder.getPrice());
		payment.setPayOrder(payOrder);
		payment.setPaymentType("Credit Card");
		paymentService.addPayment(payment);
		return "Successful credit card payment, details: \n" + payOrder.toString();
	}

	@RequestMapping(value = "/users/{userId}/buy/{shoppingCartId}/payOrder/{payOrderId}/payPayPal", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public @ResponseBody String PayWithPayPal(
			@PathVariable("userId") Integer userId,
			@PathVariable("shoppingCartId") Integer shoppingCartId,
			@PathVariable("payOrderId") Integer payOrderId,
			@ModelAttribute("email") String email,
			@ModelAttribute("password") String password) {
		PayOrder payOrder = payOrderService.getPayOrderById(payOrderId);
		double discountD = shoppingCartService
				.performDiscountPayPal(shoppingCartId);
		String discount = String.valueOf(discountD);
		payOrder.setDiscount(discount);
		payOrder.setPayStatus("Paid");
		payOrder.setPrice((float) (payOrder.getPrice() - discountD));
		payOrderService.updatePayOrder(payOrder);
		Payment payment = new Payment();
		payment.setAmount(payOrder.getPrice());
		payment.setPayOrder(payOrder);
		payment.setPaymentType("PayPal");
		paymentService.addPayment(payment);
		return "Successful credit card payment, details: \n"
				+ payOrder.toString();
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody String GetProducts() {
		return productService.listProducts().toString();
	}

	@RequestMapping(value = "/offers", method = RequestMethod.GET)
	public @ResponseBody String GetOffers() {
		return offerService.listOffers().toString();
	}

	@RequestMapping(value = "/products/find/byCategory", method = RequestMethod.GET)
	public @ResponseBody String GetProductsByCategory(
			@ModelAttribute("category") String category) {
		List<Product> products = productService
				.findProductsByCategory(category);
		return products.toString();
	}

	@RequestMapping(value = "/products/find/byName", method = RequestMethod.GET)
	public @ResponseBody String GetProductsByName(
			@ModelAttribute("name") String name) {
		List<Product> products = productService.findProductsByName(name);
		return products.toString();
	}

}
