<%@page import="java.util.ArrayList"%>
<%@page import="com.personal.todo_webapp.dao.TodoDao"%>
<%@page import="com.personal.todo_webapp.dto.TodoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To-Do Update</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="my.css">
</head>
<body>
<%int id=Integer.parseInt(request.getParameter("id"));%>
<%TodoDao dao=new TodoDao(); %>
<%TodoDto task=dao.displayTaskByIdDao(id); %>
<body class="lt-bg">
	<div class="header-box lt-blu">
		<div class="content-outer-box bold dk-blu">

			<div class="content">
				<h1>Todo App</h1>
			</div>
		</div>
		<div class="task ">
			<form action="updateTask">
            <label for="id">ID:</label> 
            		<input type="number" value="<%= task.getId()%>" name="id" > <br> <br>
            		
					<label class="input" for="name">Update your task</label><br>
					<input class="input-field" type="text" name="name" value="<%= task.getTask()%>"> 
					<input type="date" value="<%= task.getDate()%>" name="date" class="date"> 
					
					<input type="submit" class="br-red" name="date" value="Update Task">
			</form>
		</div>
</body>
</html>