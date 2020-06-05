package edu.miu.cs.cs425.eregistrarwebapi.service;

import edu.miu.cs.cs425.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    Student findById(Long id);

    Student updateStudent(Student student,Long id);

    List<Student> findAll();

    List<Student> searchByFirstName(String firstName);

    Boolean deleteStudent(Long id);
}