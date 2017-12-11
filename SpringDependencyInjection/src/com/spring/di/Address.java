package com.spring.di;

/**
 * Constructor injection with dependent object. Refer Employee.java
 */
public class Address {

	private String city;

	private String state;

	private int zipcode;

	public Address(String city, String state, int zipcode) {
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String toString() {
		return city + ", " + state + " - " + zipcode;
	}
}
