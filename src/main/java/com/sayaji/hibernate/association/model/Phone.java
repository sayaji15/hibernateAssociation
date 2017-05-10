package com.sayaji.hibernate.association.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PHONE_ID")
	private int id;
	
	@Column(name = "PHONE_TYPE", nullable = false, length = 10)
	private String type;
	
	@Column(name = "PHONE_NUMBER", nullable = false, length = 15)
	private String number;
	
	public Phone() {};
	public Phone(String type, String number)
	{
		this.type = type;
		this.number = number;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public void setNumber(String number)
	{
		this.number = number;
	}
	
	@Override
	public String toString()
	{
		return "Phone [id=" + id + ", type=" + type + ", number=" + number
				+ "]";
	}
}
