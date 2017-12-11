package com.spring.di;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Dependency Injection - Constructors, Dependent Objects, Collections
 */
public class Employee {

	private int id;

	private String name;

	private Address address; // Aggregation

	private List<String> projects;

	private Map<String, Integer> experience;

	public Employee() {
		System.out.println("Default constructor");
	}

	public Employee(int id) {
		this.id = id;
	}

	public Employee(String name) {
		this.name = name;
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// Construction injection with dependent object
	public Employee(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	// Construction injection with dependent object and Collections (List)
	public Employee(int id, String name, Address address, List<String> projects) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.projects = projects;
	}

	// Construction injection with dependent object and Collection (Map)
	public Employee(int id, String name, Address address, List<String> projects, Map<String, Integer> experience) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.projects = projects;
		this.experience = experience;
	}

	public void show() {
		System.out.println(id + " --> " + name + " --> " + address.toString());
		System.out.println("Projects : " + projects);
		System.out.println("Experience : " + experience);
		Iterator<String> it = projects.iterator();
	}
}
