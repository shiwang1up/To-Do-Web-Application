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

@WebServlet(value = "/updateTask")

public class TodoUpdateController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String date=req.getParameter("date");

		TodoDao dao = new TodoDao();
		TodoDto task=new TodoDto(id,name,LocalDate.parse(date));
		dao.updateTaskByIdDao(task);

		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);

	}
}
