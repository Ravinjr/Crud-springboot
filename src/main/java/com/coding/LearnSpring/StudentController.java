package com.coding.LearnSpring;

import com.coding.LearnSpring.model.Student;
import com.coding.LearnSpring.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/student/save")
    public Student createStudent(@RequestBody Student student){
        return repository.save(student);
    }

    @GetMapping("/student/findByEmail")
    public Student findStudent(@RequestParam("email") String email){
        return repository.findByemail(email);
    }

    @PatchMapping("/student/update")
    public Student findStudent(@RequestParam("id") Long id,@RequestParam("new_email") String email){
        Optional <Student> student= repository.findById(id);
        if (student.isPresent()){
            Student student1= student.get();
            student1.setEmail(email);
            return repository.save(student1);
        }
        return null;
    }

    @GetMapping("/student/findByEmailDomain")
    public List<Student> findStudentByDomain(@RequestParam("domain")String domain){
        return repository.findByDomain(domain);
    }


}
