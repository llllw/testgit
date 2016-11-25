package com.kingdee.domains;

import com.google.code.morphia.annotations.Embedded;

public class User extends BaseEntity {

	private static final long serialVersionUID = 8392758161648306589L;
	private String name;
	private int age;
	@Embedded
	private Address address;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public Address getAddress()
	{
		return address;
	}
	public void setAddress(Address address)
	{
		this.address = address;
	}
	
}
