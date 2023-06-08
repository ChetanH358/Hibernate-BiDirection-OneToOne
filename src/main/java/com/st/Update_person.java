package com.st;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Update_person {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Query query = entityManager.createQuery("select p from Person p where p.id = ?1");
		query.setParameter(1, 2);
		List<Person> person = query.getResultList();
		
		if(person != null) {
			for(Person ele : person) {
				ele.setName("sangeeta");
				entityTransaction.begin();
				entityManager.merge(ele);
				entityTransaction.commit();
			}
		}

	}

}
