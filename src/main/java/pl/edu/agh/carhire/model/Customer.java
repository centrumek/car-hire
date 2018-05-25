package pl.edu.agh.carhire.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
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
	@NotEmpty()
	private String firstName;

	@Column(name="lastname")
	@NotEmpty
	private String lastName;

	@Column(name="phone")
	@NotEmpty
    @Pattern(regexp = "[0-9]{9}", message = "Phone number must contain exactly 9 digits.")
	private String phone;

	@Column(name="email")
	@Email(message = "Incorrect email address.")
	@NotEmpty
	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private Set<Hire> hires;

	public void addHire(Hire hire) {
		getHires().add(hire);
		hire.setCustomer(this);
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

	public Set<Hire> getHires() {
		if (this.hires == null) {
			this.hires = new HashSet<>();
		}
		return this.hires;
	}

	public void setHires(Set<Hire> hires) {
		this.hires = hires;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, firstName='%s', lastName='%s', phone='%s']",
				id, firstName, lastName, phone);
	}


}