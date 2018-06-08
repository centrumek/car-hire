package pl.edu.agh.carhire.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="cars")
public class Car {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@NotEmpty()
	private String carBrand;

	@NotEmpty()
	private String carModel;

	@Min(1)
	@Max(20)
	@NotNull
	private Integer numberOfSeats;

	@NotEmpty()
	private String color;

	@NotEmpty()
	private String note;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
	private Set<Hire> hires;

	@Digits(integer=5, fraction=2)
	private BigDecimal pricePerDay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(BigDecimal pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Set<Hire> getHires() {
		return hires;
	}

	public void setHires(Set<Hire> hires) {
		this.hires = hires;
	}

	@Override
	public String toString() {
		return "Car{" +
				"id=" + id +
				", carBrand='" + carBrand + '\'' +
				", carModel='" + carModel + '\'' +
				", numberOfSeats=" + numberOfSeats +
				", color='" + color + '\'' +
				", note='" + note + '\'' +
				", pricePerDay=" + pricePerDay +
				'}';
	}
}
