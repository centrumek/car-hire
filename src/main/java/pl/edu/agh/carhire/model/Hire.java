package pl.edu.agh.carhire.model;

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
@Table(name = "hires")
public class Hire {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@Temporal(TemporalType.DATE)
	@FutureOrPresent
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
    @Column(name = "rental_date")
	private Date hireDate;

    @Temporal(TemporalType.DATE)
    @FutureOrPresent
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull
    @Column(name = "return_date")
    private Date returnDate;

    @ManyToOne //(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne //(cascade=CascadeType.ALL)
	@JoinColumn(name = "vehicle_id")
	@NotNull
	private Car car;

	@NotNull
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Hire{" +
				"id=" + id +
				", hireDate=" + hireDate +
				", returnDate=" + returnDate +
				", customer=" + customer +
				", car=" + car +
				", note='" + note + '\'' +
				'}';
	}
}
