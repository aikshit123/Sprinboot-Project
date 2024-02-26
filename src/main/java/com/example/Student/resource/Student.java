package com.example.Student.resource;


import com.example.Student.model.StudentDataModel;
import com.example.Student.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class Student {
    @Autowired
    private StudentService StudentService;

    @GetMapping("/get/{id}")
    public StudentDataModel getStudent(@PathVariable String id) throws Exception {
        return StudentService.getStudent(id);
    }

    @GetMapping("/getByUniversity/{university_name}")
    public List<StudentDataModel> getStudentsByUniversity(@PathVariable String university_name) {
        return StudentService.getStudentsByUniversity(university_name);
    }

    @GetMapping("/getAllStudent")
    public List<StudentDataModel> getAllStudents(){
        return StudentService.getAllStudents();
    }

    @PostMapping("/create/{name}/{age}/{aadhar}/{university_Name}")
    public String createStudent(@PathVariable String name, @PathVariable String age, @PathVariable String aadhar, @PathVariable String university_Name) {
        return StudentService.createStudent(name, age, aadhar, university_Name);
    }


}