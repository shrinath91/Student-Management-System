package com.example.smsbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smsbackend.entity.Student;
import com.example.smsbackend.service.StudentService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	private StudentService studentService;
	
	//build Add student Rest API
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student)
	{
		Student savedStudent = studentService.createStudent(student);
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}
	
	//build Get Student Rest API
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long StudId)
	{
		Student student = studentService.getStudentById(StudId);
		return ResponseEntity.ok(student);
		
	}
	
	@GetMapping
	public List<Student> getAllStudent(){
		List<Student> students = studentService.getAllStudents();
		return students;
	}
	
	@PutMapping("{Id}")
	public Student updateStudent(@PathVariable  Long Id, @RequestBody Student newStudent) {
		//TODO: process POST request
		Student student = studentService.updateStudent(Id, newStudent);
		return student;
	}
	
	@DeleteMapping("{Id}")
	public String deleteStudent(@PathVariable Long Id)
	{
		Student student = studentService.deleteStudent(Id);
		return "Id:"+student.getId()+" Name:"+student.getFname()+" has been deleteted";
	}
	
	
	
}
