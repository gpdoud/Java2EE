package com.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.dao.IStudentDAO;
import com.ssa.entity.Student;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentDAO studentDAO;
	
	@Override
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentDAO.getStudentById(id);
	}

	@Override
	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
		
	}

	@Override
	public void deleteStudentById(int id) {
		studentDAO.deleteStudentById(id);
	}

}
