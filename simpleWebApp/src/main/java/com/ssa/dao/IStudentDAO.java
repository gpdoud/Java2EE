package com.ssa.dao;

import java.util.List;

import com.ssa.entity.Student;

public interface IStudentDAO {
	
	List<Student> getAllStudents();
	Student getStudentById(Integer id);
	void addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudentById(int id);

}
