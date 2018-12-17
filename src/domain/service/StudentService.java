package domain.service;

import java.util.ArrayList;

import domain.model.Student;

public class StudentService {
	
	ArrayList<Student> students;
	
	public StudentService() {
		students = new ArrayList<>();
		Student student1 = new Student("Willem");
		addStudent(student1);
		
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void deleteStudent(String naam) {
		students.remove(getStudent(naam));
	}
	
	public Student getStudent(String naam) {
		for (Student student:students) {
			if (student.hasName(naam)) {
				return student;
			}
		}
		return null;
	}
	
	public ArrayList <Student> getStudents() {
		return this.students;
	}
	
}
