package ar.com.ignacioflores.shoppingCart.service;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.User;

public interface UserService{

	public void addUser(User user);
    public void updateUser(User user);
    public List<User> listUsers();
    public User getUserById(int userId);
    public void removeUser(int userId);
}