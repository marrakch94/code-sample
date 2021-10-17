package com.spark3.olbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Getter
@Setter
//@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long clientId;
    private String name;
    private String surname;
    private String address;
    private String salary;
    private  String email;
    private Number phoneNumber;

    @OneToMany(mappedBy="client")
	//@JsonManagedReference
	private List<Request> requests;
    
    public Client() {

    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((requests == null) ? 0 : requests.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (requests == null) {
			if (other.requests != null)
				return false;
		} else if (!requests.equals(other.requests))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", surname=" + surname + ", address=" + address
				+ ", salary=" + salary + ", email=" + email + ", phoneNumber=" + phoneNumber + ", requests=" + requests
				+ "]";
	}

	public Client(Long clientId, String name, String surname, String address, String salary, String email,
			Number phoneNumber, List<Request> requests) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.salary = salary;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.requests = requests;
	}

	public Client(String name, String surname, String address, String salary, String email, Number phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.salary = salary;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Number getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Number phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
    
}
