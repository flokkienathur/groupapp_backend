package net.justf.groupapp.model;

import java.util.ArrayList;

import net.justf.groupapp.misc.NameGenerator;

public class GroupApp {
	
	private ArrayList<Group> groups;
	private ArrayList<Teacher> teachers;
	private ArrayList<Student> students;
	
	public GroupApp(){
		groups = new ArrayList<Group>();
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
	}

	public Group getGroupById(int id){
		for(Group g : groups){
			if(g.getId() == id){
				return g;
			}
		}
		return null;
	}

	public Student getStudentById(int id){
		for(Student s : students){
			if(s.getId() == id){
				return s;
			}
		}
		return null;
	}
	
	public Teacher getTeacherById(int id){
		for(Teacher t : teachers){
			if(t.getId() == id){
				return t;
			}
		}
		return null;
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
		GroupApp app = new GroupApp();
		for(int i = 0; i < 100; i++){
			app.getStudents().add(new Student(NameGenerator.randomName(), "NOTYVM"+NameGenerator.randomName()));
			app.getTeachers().add(new Teacher("D" + NameGenerator.randomName(), "DNO"+NameGenerator.randomName()));
		}
		
		for(int i = 0; i < 7; i++){
			Group g = new Group("Group : " + NameGenerator.randomName());
			app.getGroups().add(g);
		}
		
		return app;
	}
	
	
}
