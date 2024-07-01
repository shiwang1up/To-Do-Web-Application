package com.personal.todo_webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.personal.todo_webapp.connection.TodoConnection;
import com.personal.todo_webapp.dto.TodoDto;

public class TodoDao {
	private final String INSERT_INTO_DB_QUERY = "insert into tasks(name,date) values(?,?)";
	private final String DISPLAY_ALL_TASKS= "select * from tasks";
	private final String DISPLAY_ALL_COMPLETED_TASKS= "select * from ctasks";
	private final String DELETE_TASK_BY_ID_QUERY= "delete from tasks where id=?";
	private final String GET_TASK_BY_ID_QUERY= "select * from tasks where id=?";
	private final String INSERT_INTO_CDB_QUERY = "insert into ctasks(id,name,date,cdate) values(?,?,?,?)";
	
	Connection connection=TodoConnection.getConnection();
	PreparedStatement ps;

	public TodoDto saveTaskToTodoDao(TodoDto task) {

		try {
			ps=connection.prepareStatement(INSERT_INTO_DB_QUERY);

			ps.setString(1, task.getTask());
			ps.setObject(2, task.getDate());
			ps.execute();
			return task;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList<TodoDto> displayAllTasksDao(){
		try {
			ArrayList<TodoDto> tasks=new ArrayList();
			
			ps=connection.prepareStatement(DISPLAY_ALL_TASKS);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				LocalDate date=rs.getDate("date").toLocalDate();
				
				TodoDto	task=new TodoDto(id,name,date);
				tasks.add(task);
			}
			return tasks;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	public int deleteTaskDao(int id) {
		try {
			ps = connection.prepareStatement(DELETE_TASK_BY_ID_QUERY);
			ps.setInt(1, id);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public TodoDto displayTaskByIdDao(int id) {
		TodoDto  task = null;
		try {
			ps = connection.prepareStatement(GET_TASK_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int idx = rs.getInt("id");
				String name = rs.getString("name");
				LocalDate date=rs.getDate("date").toLocalDate();

				task = new TodoDto(idx, name, date);

			}
			return task;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public int updateTaskByIdDao(TodoDto task) {

		String updateQuery = "update task set name=?,date=? where id=?";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(updateQuery);
			ps.setString(1, task.getTask());
			ps.setObject(2, task.getDate());
			ps.setInt(3, task.getId());
			return ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	public ArrayList<TodoDto> displayAllCompletedTasksDao(){
		try {
			ArrayList<TodoDto> tasks=new ArrayList();
			
			ps=connection.prepareStatement(DISPLAY_ALL_COMPLETED_TASKS);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				LocalDate date=rs.getDate("date").toLocalDate();
				LocalDate cdate=rs.getDate("cdate").toLocalDate();
				
				TodoDto	task=new TodoDto(id,name,date,cdate);
				tasks.add(task);
			}
			return tasks;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	public TodoDto saveTaskToCompletedTodoDao(TodoDto task,String cdate,int cid) {

		try {
			
			ps=connection.prepareStatement(INSERT_INTO_CDB_QUERY);
			
			ps.setInt(1, cid);
			ps.setString(2, task.getTask());
			ps.setObject(3, task.getDate());
			ps.setObject(4, cdate);
			ps.execute();
			return task;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
