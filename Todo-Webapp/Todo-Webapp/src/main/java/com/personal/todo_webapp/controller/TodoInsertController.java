package com.personal.todo_webapp.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.time.LocalDate;

import com.personal.todo_webapp.dao.TodoDao;
import com.personal.todo_webapp.dto.TodoDto;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/addTask")
public class TodoInsertController extends HttpServlet{
	
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name=req.getParameter("name");
		String date=req.getParameter("date");
		
		
		TodoDto task=new TodoDto(name,LocalDate.parse(date));
		
		TodoDao dao=new TodoDao();
		
		dao.saveTaskToTodoDao(task);
		
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);	
	}	

}
