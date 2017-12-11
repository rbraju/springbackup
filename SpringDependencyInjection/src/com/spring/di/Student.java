package com.spring.di;

import java.util.Map;

/**
 * Dependency Injection - Setter Methods
 */
public class Student {

	private int id;

	private String name;

	private Address address;

	private Map<String, Integer> marks;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public Map<String, Integer> getMarks() {
		return marks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
	}

	public void display() {
		System.out.println(id + " --> " + name + " --> " + address.toString());
		System.out.println(marks);
	}
}
