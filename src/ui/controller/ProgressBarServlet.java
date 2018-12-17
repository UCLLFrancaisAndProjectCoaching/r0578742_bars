package ui.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.model.Student;
import domain.service.StudentService;

@WebServlet("/Controller")
public class ProgressBarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentService students = new StudentService();
	
	public ProgressBarServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		}
		
		public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination;
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch(action) {
		case "getOverview":
			destination = getOverview(request, response);
			break;
		case "create":
			destination=addStudent(request,response);
			break;
		case "getDelete":
			destination = getDelete(request,response);
			break;
		case "confirmDelete":
			destination = confirmDelete(request,response);
			break;
		case "getAdd":
			destination = getAdd(request,response);
			break;
		case "confirmAdd":
			destination = confirmAdd(request,response);
			break;
		case "getRate":
			destination = getRate(request,response);
			break;
		case "confirmRate":
			destination = confirmRate(request,response);
			break;
		default:
			destination = home();
			break;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(destination);
		view.forward(request, response);
		}
		
		private String home() {
			return "index.html";
		}
		
		private String getOverview(HttpServletRequest request, HttpServletResponse response) {
			String destination = "overview.jsp";
			request.setAttribute("students", students.getStudents());
			return destination;
		} 
		
		private String addStudent(HttpServletRequest request, HttpServletResponse response) {
			   
			ArrayList<String> errors = new ArrayList<>();
			String destination = "";

			Student student = new Student();

			getName(student, request, errors);
			if (errors.size()>0) {
				request.setAttribute("errors", errors);
				return "studentForm.jsp";
			}
			else {
			students.addStudent(student);
			destination=getOverview(request, response);
			}

			return destination;

		}
		
		private void getName(Student student, HttpServletRequest request, ArrayList<String> errors) {
			String naam = request.getParameter("naam");
			try {
				student.setName(naam);
				request.setAttribute("naam", "ja");
			} catch (Exception exception) {
				request.setAttribute("naam", "nee");
				errors.add(exception.getMessage());
			}
		}
		
		private String getDelete(HttpServletRequest request, HttpServletResponse response) {
			Student student = students.getStudent(request.getParameter("name"));
			request.setAttribute("student", student);
			String destination = "delete.jsp";
			return destination;
		}
		
		private String confirmDelete(HttpServletRequest request, HttpServletResponse response) {
			students.deleteStudent(request.getParameter("name"));
			String destination = getOverview(request,response);
			return destination;
		}
		
		private String getAdd(HttpServletRequest request, HttpServletResponse response) {
			String destination = "add.jsp";
			return destination;
		}
		
		private String confirmAdd(HttpServletRequest request, HttpServletResponse response) {
			String name = request.getParameter("name");
			students.addStudent(new Student(name));
			String destination = "overview.jsp";
			request.setAttribute("students", students.getStudents());
			return destination;
		}
		
		private String getRate(HttpServletRequest request, HttpServletResponse response) {
			Student student = students.getStudent(request.getParameter("name"));
			request.setAttribute("student", student);
			String destination = "rate.jsp";
			return destination;
		}
		
		private String confirmRate(HttpServletRequest request, HttpServletResponse response) {
			Student student = students.getStudent(request.getParameter("name"));
			ArrayList<String> errors = new ArrayList<String>();
			getSamenwerking(student, errors, request);
			getCreativiteit(student, errors, request);
			request.setAttribute("student", student);
			String destination = "";
			if (errors.size() == 0) {
				request.setAttribute("students", students.getStudents());
				destination = "overview.jsp";
			} else {
				destination = "rate.jsp";
			}
			return destination;
		}
		
		private void getSamenwerking(Student student, ArrayList<String> errors, HttpServletRequest request) {
			 String samenwerking = request.getParameter("samenwerking");
			 try {
				 student.setSamenwerking(Integer.parseInt(samenwerking));
			 } catch (IllegalArgumentException e) {
				 errors.add(e.getMessage());
			 }
		}
		
		private void getCreativiteit(Student student, ArrayList<String> errors, HttpServletRequest request) {
			 String creativiteit = request.getParameter("creativiteit");
			 try {
				 student.setCreativiteit(Integer.parseInt(creativiteit));
			 } catch (IllegalArgumentException e) {
				 errors.add(e.getMessage());
			 }
		}

}
