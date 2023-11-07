package com.MySQL.crudDemo;

import com.MySQL.crudDemo.DAO.studentDAO;
import com.MySQL.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	//Execute this code when app starts
	@Bean
	public CommandLineRunner commandLineRunner(studentDAO studentDAO){
		//Java Lambda Expression
		return runner -> {
             //Execute this function when app starts
			createStudent(studentDAO);

			getStudent(studentDAO);

			findAllStudents(studentDAO);

			getByLastName(studentDAO);

			updateStudent(studentDAO);

			deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);


		};

	}

	private void deleteAllStudents(studentDAO studentDAO) {
		System.out.println("Deleting all students object");

		int numsRowsDelete=studentDAO.deleteAll();
		System.out.println("All students deleted with number of rows "+numsRowsDelete);
	}

	private void deleteStudent(studentDAO studentDAO) {
		System.out.println("Deleting student object");

        int id=3;
		studentDAO.deleteById(id);
		System.out.println("Student deleted");
	}

	private void updateStudent(studentDAO studentDAO) {
		System.out.println("Updating student object");

		Student thestudent=studentDAO.getById(1); //already implemented in the interface
		thestudent.setFirstName("Omar"); //setters in Student class
		thestudent.setLastName("Anan");

		studentDAO.update(thestudent);
		System.out.println("Student updated");

	}


	private void createStudent(studentDAO studentDAO) {
		System.out.println("Creating new student object");

		Student student= new Student("John", "Doe", "omar@gmail.com");
		Student student1= new Student("Omar", "Anan", "anan@gmail.com");
		Student student2= new Student("omar", "abouromia", "abouromia@gmail.com");
		studentDAO.save(student); //use the interface to get the method
		studentDAO.save(student1);
		studentDAO.save(student2);
		System.out.println("Students saved to the database");
		System.out.println("saved student id: " + student.getId());
	}
	private void getStudent(studentDAO studentDAO) {
		System.out.println("Create a temp student");
		Student tempStudent = new Student( "ane", "kante", "sdsds@gmail.com");
		studentDAO.save(tempStudent);

		int id=tempStudent.getId();
		System.out.println("Student created by ID "+id);
		Student myStudent=studentDAO.getById( id );
		System.out.println("Retrived student "+myStudent);
	}
	private void findAllStudents(studentDAO studentDAO) {
		System.out.println("Retriving all students");

		List<Student> students=studentDAO.findAll();

		for (Student studentx:students){
			System.out.println(studentx);
		}
	}
	private void getByLastName(studentDAO studentDAO) {
		System.out.println("Retriving all students By Last Name");

		List<Student> students=studentDAO.findByLastName("Doe");

		for (Student studentx:students){
			System.out.println(studentx);
		}
	}




};



//Class => JPA => Database

//JPA = Hibernate + EntityManager
//JPA = Java Persistence API
//JPA = ORM (Object Relational Mapping)
//helps to map Java objects to relational database tables

//EntityManager Functionality
//create, read, update, delete
//save, find , findById, delete by id

//DAO = Data Access Object
 //used to access the data from the database

