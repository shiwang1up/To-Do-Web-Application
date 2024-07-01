package com.personal.todo_webapp.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.personal.todo_webapp.dao.TodoDao;
import com.personal.todo_webapp.dto.TodoDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(value = "/complete")
public class TodoCompleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cid=Integer.parseInt(req.getParameter("id"));
		TodoDao dao=new TodoDao();
		
		TodoDto ctask=dao.displayTaskByIdDao(cid);
		
		String cdate=LocalDate.now()+"";
		
		dao.saveTaskToCompletedTodoDao(ctask,cdate,cid);
		
		dao.deleteTaskDao(cid);
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("complete.jsp");
		dispatcher.forward(req, resp);
		
		
		
		
	}

}
