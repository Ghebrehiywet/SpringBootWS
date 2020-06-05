package edu.miu.cs.cs425.eregistrarwebapi.service;


import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Student editedStudent, Long id) {
        return studentRepository.findById(id)
                .map(stu -> {
                    stu.setStudentNumber(editedStudent.getStudentNumber());
                    stu.setFirstName(editedStudent.getFirstName());
                    stu.setMiddleName(editedStudent.getMiddleName());
                    stu.setLastName(editedStudent.getLastName());
                    stu.setCgpa(editedStudent.getCgpa());
                    stu.setEnrollmentDate(editedStudent.getEnrollmentDate());
                    stu.setInternational(editedStudent.getInternational());
                    return studentRepository.save(editedStudent);
                }).orElseGet(() -> {
                    return studentRepository.save(editedStudent);
                });
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll(Sort.by("studentNumber"));
    }

    @Override
    public List<Student> searchByFirstName(String firstName) {
        return studentRepository.searchByFirstName(firstName);
    }

    @Override
    public Boolean deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return true;
    }
}
