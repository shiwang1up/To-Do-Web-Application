package com.personal.todo_webapp.dto;

import java.time.LocalDate;
import java.util.Objects;

public class TodoDto {
	private int id;
	private String task;
	private LocalDate date;
	private LocalDate cdate;
	
	
	
	public TodoDto(int id, String task, LocalDate date) {
		super();
		this.id = id;
		this.task = task;
		this.date = date;
	}
	
	public TodoDto(int id, String task, LocalDate date ,LocalDate cdate) {
		super();
		this.id = id;
		this.task = task;
		this.date = date;
		this.cdate=cdate;
	}
	

	public TodoDto( String task, LocalDate date) {
		super();
		this.task = task;
		this.date = date;
	}



	public TodoDto() {
		super();
	}

	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", task=" + task + ", date=" + date + "]";
	}

















	@Override
	public int hashCode() {
		return Objects.hash(date, id, task);
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoDto other = (TodoDto) obj;
		return Objects.equals(date, other.date) && id == other.id && Objects.equals(task, other.task);
	}







	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public String getTask() {
		return task;
	}







	public void setTask(String task) {
		this.task = task;
	}







	public LocalDate getDate() {
		return date;
	}







	public void setDate(LocalDate cdate) {
		this.date = date;
	}
	
	public LocalDate getCdate() {
		return cdate;
	}







	public void setCdate(LocalDate cdate) {
		this.cdate = cdate;
	}
	
	
	

}
