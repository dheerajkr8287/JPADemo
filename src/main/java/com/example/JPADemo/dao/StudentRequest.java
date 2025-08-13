package com.example.JPADemo.dao;

// Data Access Object(DAO)
// It's a DTO – Data Transfer Object



/*
DTO (Data Transfer Object)
👉 What it is:
A plain Java class used to transfer data between layers (especially between client and server).

👉 Why we use it:

To decouple internal entity structure from API responses or requests.

To avoid exposing sensitive fields from the entity (e.g., passwords).

To customize or optimize the shape of data sent to frontend (you might not need all fields of entity).

Helps reduce the risk of over-posting or under-posting attacks.

DTO fields don’t affect your database.

If you post DTOs to the API, the backend just ignores extra fields not mapped to Entity.



DTO (Data Transfer Object) is meant to shape the data as per your needs, especially for:

UI/frontend

API requests/responses

Aggregated data from multiple sources

Custom messages/flags

You are not restricted to keeping DTOs identical to Entities.

 */

public class StudentRequest {

    int id;

    String name;

    String course;


    String address;

    String DOB;

    String enrolmentNum;

    public String getEnrolmentNum() {
        return enrolmentNum;
    }

    public void setEnrolmentNum(String enrolmentNum) {
        this.enrolmentNum = enrolmentNum;
    }

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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
}
