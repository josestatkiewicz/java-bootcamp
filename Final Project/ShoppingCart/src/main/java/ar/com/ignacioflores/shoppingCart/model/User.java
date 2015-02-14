package ar.com.ignacioflores.shoppingCart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User", catalog = "_shoppingcart")
public class User implements java.io.Serializable {

	@Override
	public String toString() {
		return String
				.format("{\n\tidUser: %s\n\tpassword: %s\n\tfirstName: %s\n\tlastName: %s\n\temail: %s\n\tphone: %s\n\tstate: %s\n\tprovince: %s\n\tcity: %s\n\taddress: %s\n\tzipCode: %s\n}",
						idUser, password, firstName,
						lastName, email, phone, state, province, city, address,
						zipCode);
	}

	private static final long serialVersionUID = 1L;
	
	private Integer idUser;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String state;
	private String province;
	private String city;
	private String address;
	private Integer zipCode;
	private Set<ShoppingCart> shoppingCarts = new HashSet<ShoppingCart>(0);

	public User() {
	}

	public User(String password, String firstName, String lastName) {
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String password, String firstName, String lastName,
				String email, String phone, String state, String province,
				String city, String address, Integer zipCode,
				Set<ShoppingCart> shoppingCarts) {
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.state = state;
		this.province = province;
		this.city = city;
		this.address = address;
		this.zipCode = zipCode;
		this.shoppingCarts = shoppingCarts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUser", unique = true, nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstName", nullable = false, length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", nullable = false, length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", length = 90)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "state", length = 7)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "province", length = 90)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "address", length = 90)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zipCode")
	public Integer getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ShoppingCart> getShoppingCarts() {
		return this.shoppingCarts;
	}

	public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

}
