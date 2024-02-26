package com.example.Student.repository;

import com.example.Student.model.StudentDataModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDataRepo {
    private Map<String, StudentDataModel> StudentDataMap;
    private Map<String, List<StudentDataModel>> studentDataMapByUniversity;

    public StudentDataRepo() {
        StudentDataMap = new HashMap<>();
        studentDataMapByUniversity = new HashMap<>();
    }

    public StudentDataModel getStudentById(final String id) {
        return StudentDataMap.getOrDefault(id, null);
    }

    public StudentDataModel createStudent(final String id, final String name, final String age, final String aadhar, final String university_Name) {
        StudentDataModel newStudentDataModel = new StudentDataModel(id, name, age, aadhar, university_Name);
        StudentDataMap.put(id, newStudentDataModel);
        studentDataMapByUniversity
            .computeIfAbsent(university_Name, k -> new ArrayList<>())
            .add(newStudentDataModel);
        return newStudentDataModel;
    }

    public List<StudentDataModel> getStudentsByUniversity(String university_Name) {
        return studentDataMapByUniversity.getOrDefault(university_Name, Collections.emptyList());
    }

    public List<StudentDataModel> getAllStudents() {
        return new ArrayList<>(StudentDataMap.values());
    }
}