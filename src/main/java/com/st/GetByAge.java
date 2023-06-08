package com.st;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class GetByAge {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
//		age and gender
		Query query = entityManager.createQuery("select p from Person p where age>?1 and gender=?2");
		query.setParameter(1, 22);
		query.setParameter(2, "male");
		
		List<Person> person = query.getResultList();
		
		for(Person ele : person) {
			System.out.println("*******************************");		
			System.out.println("Person id "+ele.getId());
			System.out.println("Person name "+ele.getName());
			System.out.println("Person age "+ele.getAge());
			System.out.println("Person gender "+ele.getGender());
			System.out.println("*******************************");
		}
		
	}

}
