package net.justf.groupapp.model;

import java.util.List;
import static net.justf.groupapp.model.GroupAppDB.*;

public class GroupApp {
	
	
	private GroupAppDB database;
	
	public GroupApp(GroupAppDB database){
		this.database = database;
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

	//TODO: update
	public void groupAddStudent(int groupId, int studentId){
		database.exectuteRaw("UPDATE students SET inGroup=" +groupId+ " WHERE id="+studentId);
	}
	public void groupRemoveStudent(int groupId, int studentId){
		database.exectuteRaw("UPDATE students SET inGroup=" +0+ " WHERE id="+studentId);
	}
	
	//TODO: create:
	public void groupSetTeacher(int groupId, int teacherId){
		database.exectuteRaw("UPDATE teachers SET mentor=" +0+ " WHERE NOT id="+teacherId+" AND mentor="+groupId);
		database.exectuteRaw("UPDATE teachers SET mentor=" +groupId+ " WHERE id="+teacherId);
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
