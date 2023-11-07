package com.MySQL.crudDemo.DAO;

import com.MySQL.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//DAO = Data Access Object
//used to access the data from the database
//use entity manager to access the database
@Repository
public class studentDAOimplementation implements studentDAO{

    private EntityManager entityManager;
    @Autowired //constructor injection
    public studentDAOimplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override  //save the student object to the database
    @Transactional //entityManager.persist
    public void save(Student theStudent) {  //the interafce say that Student datatype will be injected
        entityManager.persist(theStudent); //use entity manager to persist the student object to the database

    }

    @Override //entityManager.find(class,Primary Key)
    public Student getById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override //entityManager.createQuery
    public List<Student> findAll() {
        //create a query
        //use entity manager to create a query
        TypedQuery<Student> query=entityManager.createQuery("from Student order by lastName", Student.class);

        //use entity manager to get the result
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> query=entityManager.createQuery("from Student where lastName=:lastNamex", Student.class);
        //set the parameter value
        query.setParameter("lastNamex", theLastName);
        return query.getResultList();
    }

    @Override
    @Transactional // entityManager.merge
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override //entityManager.remove(theStudent);
    @Transactional
    public void deleteById(Integer id) {
        //get the student by id
        Student theStudent=entityManager.find(Student.class, id);
        //delete the student
        entityManager.remove(theStudent);


    }

    @Override
    @Transactional
    public int deleteAll() {
        int numsRowsDeleted=entityManager.createQuery("delete from Student").executeUpdate();
        return numsRowsDeleted;
    }
}











//what is the use of Autowired annotation?
//Autowiring is a feature of spring framework. It maps the dependencies between the objects automatically.

//What is the use of @Repository annotation?
//The @Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.

//What is the use of @Transactional annotation?
//The @Transactional annotation is used to specify the transactional behavior of the method.
