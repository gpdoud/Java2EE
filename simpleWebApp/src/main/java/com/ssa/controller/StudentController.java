package com.ssa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssa.entity.Student;
import com.ssa.service.IStudentService;

@CrossOrigin
@Controller
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		System.err.println("GET: Get 1 student id is " + id);
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@RequestMapping(value="/student", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents() {
		System.err.println("GET: All students");
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value="/student", method = RequestMethod.POST)
	public ResponseEntity<Void> addStudent(@RequestBody Student student) {
		System.err.println("PUT: Student is " + student);
		studentService.addStudent(student);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/student", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
		System.err.println("POST: Student id is " + student.getId());
		studentService.updateStudent(student);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudentById(@PathVariable("id") Integer id) {
		System.err.println("DELETE: Student id is " + id);
		studentService.deleteStudentById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


}
