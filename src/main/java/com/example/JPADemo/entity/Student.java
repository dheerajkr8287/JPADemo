package com.example.JPADemo.entity;

import jakarta.persistence.*;

@Entity //this is class that mapping with the db class
@Table(name = "students") //this is used when class name is different from the db table name
public class Student {

    @Id //this is used for represent the primary key id in class
    @Column(name = "id")//this is used when class entity name is different from the db class entity so they help in mapping with them
    //The @GeneratedValue(strategy = GenerationType.AUTO) annotation in Java Persistence API (JPA) instructs the persistence provider (like Hibernate) to automatically generate
    // the primary key (ID) value for an entity. When using GenerationType.AUTO, the persistence provider chooses the most appropriate generation strategy based on the underlying database and its features
    @GeneratedValue(strategy = GenerationType.AUTO)
   int id;

    @Column(name = "name")
    String name;

    @Column(name ="course")
    String course;

    @Column(name = "address")
    String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
