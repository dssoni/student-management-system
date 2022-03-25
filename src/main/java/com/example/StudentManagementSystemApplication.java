package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

//		Student st1 = new Student("Ramesh", "Soni", "ds@gmail.com");
//		studentRepository.save(st1);;
//
//		Student st2 = new Student("Mehul", "Bhavsar", "mb@gmail.com");
//		studentRepository.save(st2);
//
//		Student st3 = new Student("Amul", "Patel", "ap@gmail.com");
//		studentRepository.save(st3);
	}

}
