package com.ranko.rent_a_car.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

import java.util.Date;

@Entity
@Table(name = "rentals")
public class Rental {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "rental_date")
	@FutureOrPresent
	private Date rentalDate;

	@ManyToOne //(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne //(cascade=CascadeType.ALL)
	@JoinColumn(name = "vehicle_id")
	@NotNull
	private Vehicle vehicle;

	@Min(value = 1)
	@Max(value = 90)
	private Integer days;

	@NotNull
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
