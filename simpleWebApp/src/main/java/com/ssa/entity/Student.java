package com.ssa.entity;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Integer id;
	@Column(name="first_name")
	String first_name;
	@Column(name="last_name")
	String last_name;
	@Column(name="gpa")
	Double gpa;
	@Column(name="sat")
	Integer sat;
	@Column(name="major_id")
	Integer major_id;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public Integer getSat() {
		return sat;
	}

	public void setSat(Integer sat) {
		this.sat = sat;
	}
	

	public Integer getMajor_id() {
		return major_id;
	}

	public void setMajor_id(Integer major_id) {
		this.major_id = major_id;
	}

	public Student() {		
	}
	
	@Override
	public String toString() {
		return String.format("%-20s %4.1f %4d %d", this.first_name + " " + this.last_name, this.gpa, this.sat, this.major_id);
	}

	public Student(String first_name, String last_name, Double gpa, Integer sat, Integer major_id) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.gpa = gpa;
		this.sat = sat;
		this.major_id = major_id;
	}
	
}

