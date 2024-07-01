package com.personal.todo_webapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.personal.todo_webapp.dto.TodoDto;

public class TodoConnection {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/todo","root","root");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
