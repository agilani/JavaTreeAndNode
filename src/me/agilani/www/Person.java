package me.agilani.www;

public class Person {
	
	private String name;
	private int age;
	private String status;
	
	public Person(String name, int age, String status)
	{
		this.setName(name);
		this.setAge(age);
		this.setStatus(status);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString()
	{
		return new String("Name: " + getName() + ". Age: " + getAge() + ". Status: " + getStatus());
	}
}
