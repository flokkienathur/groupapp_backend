package net.justf.groupapp;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.justf.groupapp.model.Group;
import net.justf.groupapp.model.GroupApp;
import net.justf.groupapp.model.Student;
import net.justf.groupapp.model.Teacher;

@RestController
public class DefaultController {
	
	private GroupApp app;
	
	@PostConstruct
	public void init() {
		app = GroupApp.load();
	}

	//STUDENTS
	
	@RequestMapping(value="/students/list", method={RequestMethod.GET})
    public ArrayList<Student> getStudentList() {
        return app.getStudents();
    }
	@RequestMapping(value="/students/create", method={RequestMethod.POST})
    public ArrayList<Student> createStudent(
    		@RequestParam(value = "firstName", required = true) String firstName,
    		@RequestParam(value = "lastName", required = true) String lastName
    		) {
		
		app.getStudents().add(new Student(firstName, lastName));
		
        return app.getStudents();
	}
	@RequestMapping(value="/students/remove", method={RequestMethod.POST})
    public ArrayList<Teacher> removeStudent(
    		@RequestParam(value = "student_id", required = true) int studentId
    		) {
		
		Student teacher = app.getStudentById(studentId);
		
		app.getStudents().remove(teacher);
		
        return app.getTeachers();
    }
	
	//TEACHERS
	
	@RequestMapping(value="/teachers/list", method={RequestMethod.GET})
    public ArrayList<Teacher> getTeacherList() {
        return app.getTeachers();
    }
	@RequestMapping(value="/teachers/create", method={RequestMethod.POST})
    public ArrayList<Teacher> createTeacher(
    		@RequestParam(value = "firstName", required = true) String firstName,
    		@RequestParam(value = "lastName", required = true) String lastName
    		) {
		
		app.getTeachers().add(new Teacher(firstName, lastName));
		
        return app.getTeachers();
    }
	@RequestMapping(value="/teachers/remove", method={RequestMethod.POST})
    public ArrayList<Teacher> removeTeacher(
    		@RequestParam(value = "teacher_id", required = true) int teacherId
    		) {
		
		Teacher teacher = app.getTeacherById(teacherId);
		
		app.getTeachers().remove(teacher);
		
        return app.getTeachers();
    }
	
	//GROUPS

	@RequestMapping(value="/groups/list", method={RequestMethod.GET})
    public ArrayList<Group> getGroupList() {
        return app.getGroups();
    }
	@RequestMapping(value="/groups/create", method={RequestMethod.POST})
    public ArrayList<Group> createGroup(
    		@RequestParam(value = "name", required = true) String name
    		) {
		Group group = new Group(name);
		
		app.getGroups().add(group);
		
        return app.getGroups();
    }
	@RequestMapping(value="/groups/remove", method={RequestMethod.POST})
    public ArrayList<Group> removeGroup(
    		@RequestParam(value = "group_id", required = true) int groupId
    		) {
		
		Group group = app.getGroupById(groupId);
		
		if(group != null)
			app.getGroups().remove(group);
		
        return app.getGroups();
    }
	@RequestMapping(value="/groups/set_teacher", method={RequestMethod.POST})
    public ArrayList<Group> groupSetTeacher(
    		@RequestParam(value = "group_id", required = true) int groupId,
    		@RequestParam(value = "teacher_id", required = true) int teacherId
    		) {
		
		Group group = app.getGroupById(groupId);
		Teacher teacher = app.getTeacherById(teacherId);
		
		if(group == null)
			return app.getGroups();
		
		//teacher can be null to remove the teacher
		
		group.setTeacher(teacher);
		
        return app.getGroups();
    }
	@RequestMapping(value="/groups/add_student", method={RequestMethod.POST})
    public ArrayList<Group> groupAddStudent(
    		@RequestParam(value = "group_id", required = true) int groupId,
    		@RequestParam(value = "student_id", required = true) int studentId
    		) {
		
		Group group = app.getGroupById(groupId);
		Student student = app.getStudentById(studentId);
		
		if(group == null)
			return app.getGroups();
		if(student == null)
			return app.getGroups();
		
		if(!group.hasStudent(student))
			group.addStudent(student);
		
        return app.getGroups();
    }
	@RequestMapping(value="/groups/remove_student", method={RequestMethod.POST})
    public ArrayList<Group> groupRemoveStudent(
    		@RequestParam(value = "group_id", required = true) int groupId,
    		@RequestParam(value = "student_id", required = true) int studentId
    		) {
		
		Group group = app.getGroupById(groupId);
		Student student = app.getStudentById(studentId);
		
		if(group == null)
			return app.getGroups();
		if(student == null)
			return app.getGroups();
		
		if(group.hasStudent(student))
			group.removeStudent(student);
		
        return app.getGroups();
    }
	
	
	
	
	
}
