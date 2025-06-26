package com.example.JPADemo.service;

import com.example.JPADemo.dao.StudentRequest;
import com.example.JPADemo.entity.Student;
import com.example.JPADemo.repo.StudentRepo;
import com.example.JPADemo.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class StdServiceImpl implements StdService{

    @Autowired
    StudentRepo studentRepo;//ye ek interface hai but ye extend karta h curdRepository interface ko jo class path mai iska bean(obj) bna kar rakhta h JVM or spring ke help se


    @Override
    public List<Student> getAllStudentByCourse(String courseName) {
        return studentRepo.findByCourse(courseName);
    }

    @Override
    public Student saveStdData(StudentRequest studentRequest) {
        return studentRepo.save(Utility.Mapper(studentRequest));
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.deleteById(id);

    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.getAllStudentData();
    }

    @Override
    public void updateStudent(int id, StudentRequest studentRequest) {

        Student existingStudent=studentRepo.findById(id).isPresent()?studentRepo.findById(id).get():null;

        if(existingStudent!=null){
            existingStudent.setName(studentRequest.getName());
            existingStudent.setCourse(studentRequest.getCourse());
            existingStudent.setAddress(studentRequest.getAddress());

            studentRepo.save(existingStudent);
        }else{
            System.out.println("Student not found with ID:"+id);
        }


    }


}
