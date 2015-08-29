package net.justf.groupapp;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.justf.groupapp.model.Group;
import net.justf.groupapp.model.GroupApp;
import net.justf.groupapp.model.GroupAppBuilder;
import net.justf.groupapp.model.Student;
import net.justf.groupapp.model.Teacher;

@RestController
public class DefaultController {
	
	private GroupApp app;
	
	@PostConstruct
	public void init() {
		GroupAppBuilder builder = new GroupAppBuilder();
		
		app = builder.build("database");
	}

	//STUDENTS
	
	@RequestMapping(value="/students/list", method={RequestMethod.GET})
    public List<Student> getStudentList() {
        return app.getStudents();
    }
	@RequestMapping(value="/students/create", method={RequestMethod.POST})
    public List<Student> createStudent(
    		@RequestParam(value = "firstName", required = true) String firstName,
    		@RequestParam(value = "lastName", required = true) String lastName
    		) {
		
		app.createStudent(firstName, lastName);
		
        return app.getStudents();
	}
	@RequestMapping(value="/students/remove", method={RequestMethod.POST})
    public List<Student> removeStudent(
    		@RequestParam(value = "studentId", required = true) int studentId
    		) {
		
		app.removeStudent(studentId);
		
        return app.getStudents();
    }
	
	//TEACHERS
	
	@RequestMapping(value="/teachers/list", method={RequestMethod.GET})
    public List<Teacher> getTeacherList() {
        return app.getTeachers();
    }
	@RequestMapping(value="/teachers/create", method={RequestMethod.POST})
    public List<Teacher> createTeacher(
    		@RequestParam(value = "firstName", required = true) String firstName,
    		@RequestParam(value = "lastName", required = true) String lastName
    		) {
		
		app.createTeacher(firstName, lastName);
		
        return app.getTeachers();
    }
	@RequestMapping(value="/teachers/remove", method={RequestMethod.POST})
    public List<Teacher> removeTeacher(
    		@RequestParam(value = "teacherId", required = true) int teacherId
    		) {
		
		app.removeTeacher(teacherId);
		
        return app.getTeachers();
    }
	
	//GROUPS

	@RequestMapping(value="/groups/list", method={RequestMethod.GET})
    public List<Group> getGroupList() {
        return app.getGroups();
    }
	@RequestMapping(value="/groups/create", method={RequestMethod.POST})
    public List<Group> createGroup(
    		@RequestParam(value = "name", required = true) String name
    		) {
		app.createGroup(name);
		
        return app.getGroups();
    }
	@RequestMapping(value="/groups/remove", method={RequestMethod.POST})
    public List<Group> removeGroup(
    		@RequestParam(value = "groupId", required = true) int groupId
    		) {
		
		app.removeGroup(groupId);
		
        return app.getGroups();
    }
	
	@RequestMapping(value="/groups/set_teacher", method={RequestMethod.POST})
    public List<Group> groupSetTeacher(
    		@RequestParam(value = "groupId", required = true) int groupId,
    		@RequestParam(value = "teacherId", required = true) int teacherId
    		) {
		
		app.groupSetTeacher(groupId, teacherId);
		
        return app.getGroups();
    }
	@RequestMapping(value="/groups/add_student", method={RequestMethod.POST})
    public List<Group> groupAddStudent(
    		@RequestParam(value = "groupId", required = true) int groupId,
    		@RequestParam(value = "studentId", required = true) int studentId
    		) {

		app.groupAddStudent(groupId, studentId);
		
        return app.getGroups();
    }
	@RequestMapping(value="/groups/remove_student", method={RequestMethod.POST})
    public List<Group> groupRemoveStudent(
    		@RequestParam(value = "groupId", required = true) int groupId,
    		@RequestParam(value = "studentId", required = true) int studentId
    		) {
		
		app.groupRemoveStudent(groupId, studentId);
		
        return app.getGroups();
    }
	
	
	
	
	
}
