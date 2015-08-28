package net.justf.groupapp.model;

import java.util.ArrayList;
import java.util.List;
import static net.justf.groupapp.model.GroupAppDB.*;

public class GroupApp {
	
	private ArrayList<Group> groups;
	private ArrayList<Teacher> teachers;
	private ArrayList<Student> students;
	
	protected int studentId = 0;
	protected int teacherId = 0;
	protected int groupId = 0;
	
	private GroupAppDB database;
	
	public GroupApp(GroupAppDB database){
		groups = new ArrayList<Group>();
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
		
		this.database = database;
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
	
	public List<Group> getGroups() {
		return database.getGroups();
	}
	public List<Teacher> getTeachers() {
		return database.getTeachers();
	}
	public List<Student> getStudents() {
		return database.getStudents();
	}

	public void createStudent(String firstName, String lastName){
		database.insert(TABLE_STUDENTS, VALUES_STUDENTS, firstName, lastName);
	}
	public void createTeacher(String firstName, String lastName){
		database.insert(TABLE_TEACHERS, VALUES_TEACHERS, firstName, lastName);
	}
	public void createGroup(String name){
		database.insert(TABLE_GROUPS, VALUES_GROUPS, name);
	}
	public void removeStudent(int id){
		database.delete(TABLE_STUDENTS, id);
	}
	public void removeTeacher(int id){
		database.delete(TABLE_TEACHERS, id);
	}
	public void removeGroup(int id){
		database.delete(TABLE_GROUPS, id);
	}
	
	
}
