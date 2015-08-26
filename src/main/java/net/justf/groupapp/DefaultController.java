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
	
	@RequestMapping(value="/groups/create", method={RequestMethod.POST})
    public ArrayList<Group> groupSetTeacher(
    		@RequestParam(value = "group_id", required = true) int groupId,
    		@RequestParam(value = "teacher_id", required = true) int teacherId
    		) {
		
		for(Group group : app.getGroups()){
			
		}
		
        return app.getGroups();
    }
	
	
	
	
	
	
}
