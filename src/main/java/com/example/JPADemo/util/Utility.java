package com.example.JPADemo.util;

import com.example.JPADemo.dao.StudentRequest;
import com.example.JPADemo.entity.Student;
import com.example.JPADemo.repo.StudentRepo;

public class Utility {


    public static  Student  Mapper(StudentRequest studentRequest){
        Student student=new Student();
        student.setName(studentRequest.getName());
        student.setAddress(studentRequest.getAddress());
        student.setCourse(studentRequest.getCourse());
        return student;




    }


   public  static  Student updateStudentFromRequest(Student existingStudent,StudentRequest studentRequest){
        existingStudent.setName(studentRequest.getName());
        existingStudent.setCourse(studentRequest.getCourse());
        existingStudent.setAddress(studentRequest.getAddress());
        return  existingStudent;
   }

}
