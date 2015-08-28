package net.justf.groupapp.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class GroupAppBuilder {
	
	public GroupApp build(String database){
		//create the app to return
		GroupAppDB db = new GroupAppDB(database);
		GroupApp app = new GroupApp(db);
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			//make sure the static block is executed
			//to load the jdbc driver
			Class.forName("org.sqlite.JDBC");
			
			connection = DriverManager.getConnection("jdbc:sqlite:"+database+".db");
			statement = connection.createStatement();

			executeScript(statement, new File("startup.sql"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				statement.close();
			}catch(Exception e){e.printStackTrace();}
			try{
				connection.close();
			}catch(Exception e){e.printStackTrace();}
		}
		
		return app;
	}
	
	private boolean executeScript(Statement statement, File scriptFile){
		if(!scriptFile.exists())
			return false;
		
		try{
			Scanner scanner = new Scanner(scriptFile);
			StringBuilder builder = new StringBuilder();
			
			while(scanner.hasNextLine()){
				String line = scanner.nextLine().trim();
				if(!line.startsWith("--") && !line.isEmpty()){
					builder.append(line);
					builder.append('\n');
				}
			}
			
			scanner.close();
			
			//ugly way of going about things
			String[] statements = builder.toString().split(";");
			
			for(String st : statements){
				if(!st.trim().isEmpty()){
					statement.execute(st);
				}
			}
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}
