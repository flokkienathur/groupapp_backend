package net.justf.groupapp.model;

public class Person {
	
	private static int currentId = 1000;
	
	private int id;
	
	private String firstName;
	private String lastName;

	protected Person(){
		
	}
	
	public Person(int id, String firstName, String lastName){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.id = id;
	}

	public Person(String firstName, String lastName){
		this(currentId++, firstName, lastName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
