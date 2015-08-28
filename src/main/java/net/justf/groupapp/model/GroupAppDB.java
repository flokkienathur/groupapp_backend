package net.justf.groupapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupAppDB {

	public static final String CONST_ID = "id";
	public static final String CONST_FIRSTNAME = "firstName";
	public static final String CONST_LASTNAME = "lastName";
	public static final String CONST_NAME = "name";
	
	public static final String TABLE_STUDENTS = "students";
	public static final String TABLE_TEACHERS = "teachers";
	public static final String TABLE_GROUPS = "groups";

	public static final String[] VALUES_STUDENTS = {CONST_FIRSTNAME, CONST_LASTNAME};
	public static final String[] VALUES_TEACHERS = {CONST_FIRSTNAME, CONST_LASTNAME};
	public static final String[] VALUES_GROUPS = {CONST_NAME};
	
	private String database;
	
	public GroupAppDB(String database) {
		this.database = database;
	}
	
	public List<Student> getStudents(){
		return getStudents("1");
	}

	public List<Student> getStudents(String filter){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			connection = open();
			statement = connection.createStatement();
			
			List<Student> list = new ArrayList<Student>();
			
			resultSet = statement.executeQuery("SELECT * FROM " + TABLE_STUDENTS + " WHERE " + filter);
			
			while(resultSet.next()){
				Student s = new Student(resultSet.getInt("id"), resultSet.getString(CONST_FIRSTNAME), resultSet.getString(CONST_LASTNAME));
				list.add(s);
			}
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<Student>();
		}finally{
			safeClose(resultSet,statement,connection);
		}
		
	}
	

	public List<Group> getGroups(){
		return getGroups("1");
	}
	
	public List<Group> getGroups(String filter){
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			connection = open();
			statement = connection.createStatement();
			
			List<Group> list = new ArrayList<Group>();
			
			resultSet = statement.executeQuery("SELECT * FROM " + TABLE_GROUPS + " WHERE " + filter);
			
			while(resultSet.next()){
				Group group = new Group(resultSet.getInt("id"), resultSet.getString(CONST_NAME));
				
				list.add(group);
			}
			
			return list;	
		}catch(Exception e){
			return new ArrayList<Group>();
		}finally{
			safeClose(resultSet,statement,connection);
		}

		
	}

	public List<Teacher> getTeachers(){
		return getTeachers("1");
	}

	public List<Teacher> getTeachers(String filter){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			connection = open();
			statement = connection.createStatement();
			
			List<Teacher> list = new ArrayList<Teacher>();
			
			resultSet = statement.executeQuery("SELECT * FROM " + TABLE_TEACHERS + " WHERE " + filter);
			
			while(resultSet.next()){
				Teacher s = new Teacher(resultSet.getInt("id"), resultSet.getString(CONST_FIRSTNAME), resultSet.getString(CONST_LASTNAME));
				list.add(s);
			}
			
			return list;	
		}catch(Exception e){
			return new ArrayList<Teacher>();
		}finally{
			safeClose(resultSet,statement,connection);
		}
	}
	
	public boolean insert(String table, String[] insertList, Object... values){
		StringBuilder builder = new StringBuilder();
		
		builder.append("INSERT INTO ");
		builder.append(table);
		builder.append("(");
		
		for(int i = 0; i < insertList.length; i++){
			builder.append(insertList[i]);
			if(i != insertList.length-1)
				builder.append(",");
		}
		builder.append(") VALUES (");
		
		for(int i = 0; i < values.length; i++){
			//put quotation marks around everything
			//integers get autoconverted
			builder.append("\"");
			builder.append(values[i]);
			builder.append("\"");
			if(i != values.length-1)
				builder.append(",");
		}
		
		builder.append(")");
		
		System.out.println(builder);
		
		return exectuteRaw(builder.toString());
	}
	
	public boolean delete(String table, int id){
		return delete(table, "id=" + id);
	}
	
	public boolean delete(String table, String filter){
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE FROM ");
		builder.append(table);
		builder.append(" WHERE ");
		builder.append(filter);
		
		return exectuteRaw(builder.toString());
	}
	
	protected void safeClose(AutoCloseable ... closeables){
		//safely closes all given resources
		for(AutoCloseable c : closeables){
			try{
				if(c != null)
					c.close();
			}catch(Exception e){e.printStackTrace();}
		}
	}
	
	protected Connection open() throws SQLException{
		return DriverManager.getConnection("jdbc:sqlite:"+database+".db");
	}

	private boolean exectuteRaw(String raw){
		Connection connection = null;
		Statement statement = null;
		try{
			connection = open();
			statement = connection.createStatement();
			
			return statement.execute(raw);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			safeClose(statement,connection);
		}
		return false;
	}
}
