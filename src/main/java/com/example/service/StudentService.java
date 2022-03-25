package com.example.service;

import java.util.List;

import com.example.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student saveStudent(Student student);

	Student editStudent(Student student);

	Student findStudentById(Long id);

	void deleteStudentById(Long id);

}
