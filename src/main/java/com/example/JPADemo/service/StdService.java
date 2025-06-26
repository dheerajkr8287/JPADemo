package com.example.JPADemo.service;

import com.example.JPADemo.dao.StudentRequest;
import com.example.JPADemo.entity.Student;

import java.util.List;

public interface StdService {

    public List<Student> getAllStudentByCourse(String courseName);


    Student saveStdData(StudentRequest studentRequest);

    void deleteStudent(int id);

    List<Student>   getAllStudent();

    void updateStudent(int id,StudentRequest studentRequest);


}
