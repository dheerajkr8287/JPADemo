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



/*

 What is a Mapper?
A Mapper is a class or tool used to convert between:

Entity → DTO (for API response)

DTO → Entity (for saving to DB)

Because:

Entity = database model

DTO = data for APIs / UI (can have extra fields, omit sensitive fields)


 Mapper Class (Manual)--->

public class UserMapper {

    public static UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        // ✅ Set custom field
        dto.setGreetingMessage("Hello, " + user.getName() + "!");
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        // Custom fields like greetingMessage are ignored
        return user;
    }
}


 ---> BY using MapStruct(Automatic Mapping Tool)

MapStruct is a Java annotation-based code generator that automatically creates mappers at compile time to convert between DTOs and Entities.

✅ Benefits:
No manual setX() and getY() mapping code

Fast (compile-time, no reflection)

Easy to use

Clean and maintainable

Because:

Entity = database model

DTO = data for APIs / UI (can have extra fields, omit sensitive fields)
✅ 1. Entity → DTO

public static UserDTO toDto(User user)
🔁 Direction: Database Entity → API DTO

🌐 Used in: GET requests

🎯 Purpose: When you're fetching data from the database and sending it to the frontend/client in a clean format.

✅ Example:

http

GET /users
Fetch users from DB (as Entity)

Convert them to DTO

Return List<UserDTO> in the response

✅ 2. DTO → Entity

public static User toEntity(UserDTO dto)
🔁 Direction: API DTO → Database Entity

🌐 Used in: POST (or PUT) requests

🎯 Purpose: When you're receiving data from the client and saving it to the database.

✅ Example:

http

POST /users
Receive UserDTO from request body

Convert it to User (Entity)

Save to database



--> Example of MapStruct Mapper

import org.mapstruct.*;

@Mapper(componentModel = "spring")  // Generates Spring Bean
public interface UserMapper {

    UserDTO toDto(User user);        // Entity → DTO

    @InheritInverseConfiguration     // Reuse config from above
    User toEntity(UserDTO dto);      // DTO → Entity
}


MapStruct Key Annotations (Explained Simply)

Annotation	Use & Explanation
@Mapper	Tells MapStruct this is a mapping interface
componentModel = "spring"	Makes the mapper a Spring bean (so you can @Autowired it)
@Mapping	Customizes mapping (e.g. different field names or derived values)
@Mappings	Group of multiple @Mapping annotations
@InheritInverseConfiguration	Reuses the opposite mapping config (DTO → Entity)
@Named	Gives a mapping method a name (used for nested/custom mappings)
@BeanMapping	Customize how nulls, ignore fields, etc., are handled
@MappingTarget	Used to update an existing entity instead of creating a new one

 */