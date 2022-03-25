package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Student;
import com.example.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handler method to list Students and return ModelAndView
	@GetMapping("/students")
	public String listAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// to hold student form's data
		Student student = new Student();
		model.addAttribute("student", student);
		return "createstudent";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {

		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {

		model.addAttribute("student", studentService.findStudentById(id));
		return "editstudent";
	}

	@PostMapping("/students/{id}")
	public String editStudent(@PathVariable Long id, @ModelAttribute Student student, Model model) {

		// get Student from DB by ID
		Student oldStudentData = studentService.findStudentById(id);
		oldStudentData.setId(student.getId());
		oldStudentData.setEmail(student.getEmail());
		oldStudentData.setFirstname(student.getFirstname());
		oldStudentData.setLastname(student.getLastname());

		// save updates Student object
		studentService.editStudent(oldStudentData);

		return "redirect:/students";
	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {

		// delete Student record with ID
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
