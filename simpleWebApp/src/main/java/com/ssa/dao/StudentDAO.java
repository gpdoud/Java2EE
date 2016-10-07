package com.ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssa.entity.Student;

@Transactional
@Repository
public class StudentDAO implements IStudentDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		String hql = "FROM Student as s ORDER BY s.id";
		return (List<Student>) hibernateTemplate.find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Student getStudentById(Integer id) {
		String hql = "FROM Student as s WHERE s.id = " + id;
		System.err.println(hql);
		List<Student> students = (List<Student>) hibernateTemplate.find(hql);
		return students.get(0);
	}

	@Override
	public void addStudent(Student student) {
		System.err.println(student);
		hibernateTemplate.save(student);
	}

	@Override
	public void updateStudent(Student student) {
		//System.err.println("Student id is " + student.getId());
		Student oldStudent = getStudentById(student.getId());
		oldStudent.setFirst_name(student.getFirst_name());
		oldStudent.setLast_name(student.getLast_name());
		oldStudent.setSat(student.getSat());
		oldStudent.setGpa(student.getGpa());
		oldStudent.setMajor_id(student.getMajor_id());
		hibernateTemplate.update(oldStudent);
	}

	@Override
	public void deleteStudentById(int id) {
		System.err.println("Delete student id = " + id);
		hibernateTemplate.delete(getStudentById(id));
	}

}
