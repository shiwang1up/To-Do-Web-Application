package com.personal.todo_webapp.controller;

import java.io.IOException;

import com.personal.todo_webapp.dao.TodoDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(value="/taskDelete")

public class TodoDeleteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		TodoDao dao=new TodoDao();
		
		dao.deleteTaskDao(id);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);
		
		
	}
}
