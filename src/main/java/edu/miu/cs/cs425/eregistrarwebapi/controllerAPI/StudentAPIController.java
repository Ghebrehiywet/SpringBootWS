package edu.miu.cs.cs425.eregistrarwebapi.controllerAPI;


import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
import edu.miu.cs.cs425.eregistrarwebapi.validation.StudentValidationException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentAPIController {
    final StudentService studentService;

    public StudentAPIController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<Student> allStudents(Model model) {
        return studentService.findAll();
    }

    @GetMapping("/list/{id}")
    public Student studentDetails(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student student, BindingResult result) throws StudentValidationException {
        if (result.hasErrors()) {
            throw new StudentValidationException(result.getAllErrors());
        }
        return studentService.addStudent(student);
    }

    @PutMapping("/edit")
    public Student editStudent(@Valid @RequestBody Student student, BindingResult result) throws StudentValidationException {
        if (result.hasErrors()) {
            throw new StudentValidationException(result.getAllErrors());
        }

        return studentService.updateStudent(student,student.getStudentId());
    }

    @DeleteMapping("/delete")
    public Boolean deleteStudent(@Valid @RequestBody Student student, BindingResult result) throws StudentValidationException {
        if (result.hasErrors()) {
            throw new StudentValidationException(result.getAllErrors());
        }

        return studentService.deleteStudent(student.getStudentId());
    }

}
