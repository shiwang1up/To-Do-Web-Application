<%@page import="java.util.ArrayList"%>
<%@page import="com.personal.todo_webapp.dao.TodoDao"%>
<%@page import="com.personal.todo_webapp.dto.TodoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Completed To-Do</title>
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
			<label class="input" for="name">Completed tasks</label><br>
			
			</form>
		</div>

		<div class="display l-green">
			<h4 class="input">Your Tasks</h4>
			<table border="1" class="table">
				<tr>
					<th style="width: 5%">ID</th>
					<th style="width: 60%" >Task Name</th>
					<th style="width: 15%">Due Date</th>
					<th style="width: 15%">Completed Date</th>
					<th style="width: 5%">Remove</th>
				</tr>
				
				<%TodoDao dao=new TodoDao(); %>
				
				
				
				
				<%ArrayList<TodoDto> tasks=dao.displayAllCompletedTasksDao(); %>
				
				
				<%for(TodoDto task:tasks) {%>
				
				<tr>
					<td class="data-main"><%= task.getId()   %></td>
					<td  ><%= task.getTask() %></td>
					<td class="data-main"><%= task.getDate() %></td>
					<td class="data-main"><%= task.getCdate()  %></td>
					<td> <a href="ctaskDelete?id=<%=task.getId()%> "><input class="br-red" type="button" value="Delete"></a></td>
					
					
				</tr>
				<%} %>


			</table>
		</div>
	<a href="index.jsp"><input style="Margin: 20px; padding: 5px" type="button"  value="Display All Tasks" ></a>
	</div>
	
</body>

</body>
</html>