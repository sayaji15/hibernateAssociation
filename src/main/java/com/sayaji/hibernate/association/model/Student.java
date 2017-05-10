package com.sayaji.hibernate.association.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	private int id;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_PHONE", joinColumns = {@JoinColumn(name = "STUDENT_ID")},
	    inverseJoinColumns = {@JoinColumn(name = "PHONE_ID")})
	private Set<Phone> phoneNumbers;
	
	public Student() {}
	
	public Student(String firstName, String lastName, Set<Phone> phoneNumbers)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumbers = phoneNumbers;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Set<Phone> getPhoneNumbers()
	{
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<Phone> phoneNumbers)
	{
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString()
	{
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNumbers=" + phoneNumbers + "]";
	}
}
