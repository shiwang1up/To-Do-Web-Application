<%@page import="java.util.ArrayList"%>
<%@page import="com.personal.todo_webapp.dao.TodoDao"%>
<%@page import="com.personal.todo_webapp.dto.TodoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To-Do Web Application</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="my.css">
</head>
<body>
<body class="lt-bg">
	<div class="header-box lt-blu">
		<div class="content-outer-box bold dk-blu">

			<div class="content">
				<h1>Todo App</h1>
			</div>
		</div>
		<div class="task ">
			<label class="input" for="name">Add new task</label><br>
			<form action="addTask">
				<input class="input-field" placeholder="Task name" type="text" name="name" id="name"> 
					<input type="date" name="date" id="date" required> 
					
					<input type="submit" class="br-red" value="Add Task">
			</form>
		</div>

		<div class="display l-green">
			<h4 class="input">Your Tasks</h4>
			<table border="1" class="table">
				<tr>
					<th style="width: 5%">ID</th>
					<th style="width: 60%" >Task Name</th>
					<th style="width: 15%">Due Date</th>
					<th colspan="3" style="width: 20%">Actions</th>
				</tr>
				
				
				<%TodoDao dao=new TodoDao(); %>
				<%ArrayList<TodoDto> tasks=dao.displayAllTasksDao(); %>
				
				
				<%for(TodoDto task:tasks) {%>
				
				<tr>
					<td class="data-main"><%= task.getId()   %></td>
					<td  ><%= task.getTask() %></td>
					<td class="data-main"><%= task.getDate() %></td>
					<td> <a href="taskDelete?id=<%=task.getId()%> "><input class="br-red" type="button" value="Delete"></a></td>
					<td> <a href="Update.jsp?id=<%=task.getId()%> "><input class="br-red" type="button" value="Update"></a></td>
					<td> <a href="complete?id=<%=task.getId()%> "> <input class="br-red" type="button" value="Complete"></a></td>
				</tr>
				<%} %>


			</table>
			
			
		</div>
			<a href="complete.jsp"><input style="Margin: 20px; padding: 5px" type="button"  value="Display Completed Tasks" ></a>
	</div>
</body>

</body>
</html>