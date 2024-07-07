package com.personal.todo_webapp.controller;

import java.io.IOException;

import com.personal.todo_webapp.dao.TodoDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/ctaskDelete")
public class TodoCtaskDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		TodoDao dao = new TodoDao();

		dao.deleteCtaskDao(id);

		RequestDispatcher dispatcher = req.getRequestDispatcher("complete.jsp");
		dispatcher.forward(req, resp);

	}

}
