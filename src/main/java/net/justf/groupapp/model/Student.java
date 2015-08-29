package net.justf.groupapp.model;


public class Student extends Person{
	
	//nullable :D
	private Integer inGroup;

	protected Student(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

	public void setInGroup(Integer group){
		inGroup = group;
	}
	
	public Integer getInGroup(){
		return inGroup;
	}
}
