package com.MySQL.crudDemo.DAO;
import com.MySQL.crudDemo.entity.Student;
import java.util.List;

//studentDAO.-----
public interface studentDAO {
    void save (Student student);

    Student getById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void deleteById(Integer id);
   //TRUNCATE
    int deleteAll();





}
