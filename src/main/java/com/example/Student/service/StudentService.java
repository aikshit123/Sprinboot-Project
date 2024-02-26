package com.example.Student.service;

import com.example.Student.model.StudentDataModel;
import com.example.Student.repository.StudentDataRepo;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service

public class StudentService {

    @Autowired
    public StudentDataRepo StudentDataRepo;

    public String createStudent(final String StudentName, final String StudentAge, final String StudentAadhar, final String StudentUniversity) {
        String randomId = UUID.randomUUID().toString();
        StudentDataModel StudentDataModel =  StudentDataRepo.createStudent(randomId, StudentName, StudentAge, StudentAadhar, StudentUniversity);
        return StudentDataModel.getId();
    }

    public StudentDataModel getStudent(final String id) throws BadRequestException {
        StudentDataModel StudentDataModel = StudentDataRepo.getStudentById(id);

        if(StudentDataModel == null) {
            throw new BadRequestException("Invalid User");
        }

        return StudentDataModel;
    }

    public List<StudentDataModel> getStudentsByUniversity(String universityName) {
        return StudentDataRepo.getStudentsByUniversity(universityName);
    }

    public List<StudentDataModel> getAllStudents() {
        return StudentDataRepo.getAllStudents();
    }
}