package net.justf.groupapp.model;

public class Teacher extends Person{
	
	//nullable :D
	private Integer mentor;
	
	protected Teacher(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

	public Integer getMentor() {
		return mentor;
	}

	public void setMentor(Integer mentor) {
		this.mentor = mentor;
	}

}
