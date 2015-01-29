package ar.com.ignacioflores.shoppingcart.service;

import java.io.Serializable;

import ar.com.ignacioflores.shoppingcart.domain.User;

public interface UserManager extends Serializable{
	
	public void newUser();
	public String showUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	
}
