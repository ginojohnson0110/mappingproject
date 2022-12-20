package com.example.demo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Authorid;
	private String address;

	@OneToOne(cascade = CascadeType.ALL)
	private  Author name;

	public long getAuthorid() {
		return Authorid;
	}

	public void setAuthorid(long authorid) {
		Authorid = authorid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Author getName() {
		return name;
	}

	public void setName(Author name) {
		this.name = name;
	}

	public Person(long authorid, String address, Author name) {
		super();
		Authorid = authorid;
		this.address = address;
		this.name = name;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Person [Authorid=" + Authorid + ", address=" + address + ", name=" + name + "]";
	}

	

}