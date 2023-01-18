package com.bitlabs.dao;

import java.util.List;
import com.bitlabs.model.Student;

public interface Dao {

	int addStudentDetails(Student std);

	String login(Student std);

	List<Student> viewAllStudents();

	boolean deleteStudent(int parseInt);

	Student getById(int parseInt);

}
