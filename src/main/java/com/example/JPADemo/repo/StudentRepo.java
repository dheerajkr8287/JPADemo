package com.example.JPADemo.repo;

import com.example.JPADemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//CrudRepository <> ke andar kis type ka class h,aur uska id ka type kya h dege

//prdefined frame work ko power jo deta h springframework,JVM
//ye interface bina implements kiye obj class path mai jvm or spring ke help se bana kar rakh leta h jo iska obj use karta h  wo autowired lga leta h


//JPA repository -curd repository+pagination
@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    //select* from students where course = "java";

    public List<Student> findByCourse(String course);

    @Query(value = "select * from students",nativeQuery = true)
   public List<Student> getAllStudentData();
}


/*
👉 What it is:
An interface that extends JpaRepository or CrudRepository.

👉 Why we use it:

It provides methods to perform CRUD operations on entities.

Spring Data automatically creates implementations at runtime.
 */