package com.example.smsbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.smsbackend.entity.Student;
import com.example.smsbackend.repository.StudentRepository;
import com.example.smsbackend.userException.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service	
@AllArgsConstructor
public class StudentService{

	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		Student savedStudent = studentRepository.save(student);
		return savedStudent;
	}
	
	public Student getStudentById(Long StudentId) {
		Student student = studentRepository.findById(StudentId)
		 	.orElseThrow(()->new ResourceNotFoundException("Employee not exist: "+StudentId));
		return student;
	}
	
	public List<Student> getAllStudents(){
		List<Student> students = studentRepository.findAll();
		return students;
	}
	
	public Student updateStudent(Long id, Student newStudent)
	{
		Student oldStudent = studentRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist: "+id));
		
		oldStudent.setFname(newStudent.getFname());
		oldStudent.setLname(newStudent.getLname());
		oldStudent.setEmail(newStudent.getEmail());
		
		oldStudent = studentRepository.save(oldStudent);
		return oldStudent;
	}
	
	public Student deleteStudent(Long Id) {
		Student student = studentRepository.findById(Id)
					.orElseThrow(()->new ResourceNotFoundException("No such Student exists"+Id));
		studentRepository.delete(student);
		return student;
	}
	

}
