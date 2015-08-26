package net.justf.groupapp.model;

import java.util.ArrayList;

public class GroupApp {
	
	private ArrayList<Group> groups;
	private ArrayList<Teacher> teachers;
	private ArrayList<Student> students;
	
	public GroupApp(){
		groups = new ArrayList<Group>();
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
	}
	
	public ArrayList<Group> getGroups() {
		return groups;
	}
	public void setGroups(ArrayList<Group> groups) {
		this.groups = groups;
	}
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	public static GroupApp load(){
		return new GroupApp();
	}
	
	
}
