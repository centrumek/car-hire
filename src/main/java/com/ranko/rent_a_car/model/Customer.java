package com.ranko.rent_a_car.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@Column(name="firstname")
	@NotEmpty
	private String firstName;

	@Column(name="lastname")
	@NotEmpty
	private String lastName;

	@Column(name="phone")
	@NotEmpty
	private String phone;

	@Column(name="email")
	@Email
	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private Set<Rental> rentals;


	public void addRental(Rental rental) {
		getRentals().add(rental);
		rental.setCustomer(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Rental> getRentals() {
		if (this.rentals == null) {
			this.rentals = new HashSet<>();
		}
		return this.rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, firstName='%s', lastName='%s', phone='%s']",
				id, firstName, lastName, phone);
	}


}