package net.justf.groupapp.model;

import java.util.ArrayList;

public class Group {
	
	private int id;
	
	private ArrayList<Student> students;
	private Teacher teacher;
	
	private String name;
	
	public Group(int id, String name){
		this.setName(name);
		setId(id);
		students = new ArrayList<Student>();
	}
	

	public boolean hasStudent(Student s){
		return students.contains(s);
	}
	
	public void addStudent(Student s){
		students.add(s);
	}
	
	public void removeStudent(Student s){
		students.remove(s);
	}
	
	public Student getStudentByIndex(int index){
		return students.get(index);
	}
	
	public int size(){
		return students.size();
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
