package pl.edu.agh.carhire.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.Date;
import java.util.Objects;

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
    @Column(name = "hire_date")
	@NotNull
	private Date hireDate;

    @Temporal(TemporalType.DATE)
    @Future
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "return_date")
	@NotNull
    private Date returnDate;

    @ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	@Transient
	private int Days;

	@NotEmpty
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

	public int getDays() {
		return Days;
	}

	public void setDays(int days) {
		Days = days;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Hire hire = (Hire) o;
		return Objects.equals(id, hire.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Hire{" +
				"id=" + id +
				", hireDate=" + hireDate +
				", returnDate=" + returnDate +
				", customer=" + customer +
				", car=" + car +
				", Days=" + Days +
				", note='" + note + '\'' +
				'}';
	}
}
