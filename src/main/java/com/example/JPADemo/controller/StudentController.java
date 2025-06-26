package com.example.JPADemo.controller;

import com.example.JPADemo.dao.StudentRequest;
import com.example.JPADemo.entity.Student;
import com.example.JPADemo.service.StdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/std")
public class StudentController {

    @Autowired
    StdService stdService;

    @GetMapping("/get/{courseName}")
    public List<Student> getStudentByCourse(@PathVariable String courseName){

        List<Student> allStudentByCourse = stdService.getAllStudentByCourse(courseName);
        return allStudentByCourse;


    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody StudentRequest studentRequest){
        // Mapping: StudentRequest → Student (Entity)
        //"Take the JSON from the HTTP request body, and convert it into a Java object."

        //agar mai ek json isi parkar ka dala toh mai usese map kar duga

        //yaha par requestbody ke help se studentRequest ka object student ke obj se mapping hoga aur jo student mai hoga wahi save hoga DB mai
      return   stdService.saveStdData(studentRequest);

    }

    @DeleteMapping("delete/{id}")
    public  void deleteStudent(@PathVariable int id){
        stdService.deleteStudent(id);

    }

    @GetMapping("/get")
    public List<Student> getAllStudent(){

        List<Student> allStudent = stdService.getAllStudent();
        return allStudent;


    }


    @PutMapping("update/{id}")
    public void updateStudent(@PathVariable int id,@RequestBody StudentRequest studentRequest){


        stdService.updateStudent(id,studentRequest);


    }


}
