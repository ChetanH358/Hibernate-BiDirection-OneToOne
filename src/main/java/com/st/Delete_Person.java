package com.st;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete_Person {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("select p from Person p where p.name = ?1");
		query.setParameter(1, "sangeeta");
		List<Person> person = query.getResultList();

		for (Person ele : person) {
			Query query_pan = entityManager.createQuery("select p from PANCard p where p.pid = ?1");
			query_pan.setParameter(1, ele.getId());
			List<PANCard> list_pan = query_pan.getResultList();
			for (PANCard pan_ele : list_pan) {
				entityTransaction.begin();
				entityManager.remove(pan_ele);
				entityManager.remove(ele);
				entityTransaction.commit();
			}
		}
		
	}

}
