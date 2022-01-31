package com.ty.student.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.student.Dto.Student;


public class StudentDao {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		return entityManagerFactory.createEntityManager();
	}

	public void saveUser(Student student) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}

	public Student getUserById(int id) {
		entityManager = getManager();
		return entityManager.find(Student.class, id);
	}
	public List<Student> getAllUser() {
		entityManager = getManager();
		Query query=entityManager.createQuery("select c from Student c");
		return query.getResultList();
	}
	public void updateUser(Student student) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		
		
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		
	}
	public boolean delete(int id) {
		entityManager = getManager(); 
		entityTransaction = entityManager.getTransaction();
		Student student=entityManager.find(Student.class, id);
		if(student!=null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

}
