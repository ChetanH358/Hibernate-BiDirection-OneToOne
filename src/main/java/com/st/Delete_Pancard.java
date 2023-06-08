package com.st;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete_Pancard {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

//		Name : Ankita and pan_num : ANK5564 <-- got deleted
		
		Query query = entityManager.createQuery("select p from PANCard p where p.pan_num = ?1");
		query.setParameter(1, "ANK5564");
		List<PANCard> pan = query.getResultList();

		for (PANCard ele : pan) {
			Query query_person = entityManager.createQuery("select p from Person p where p.id = ?1");
			query_person.setParameter(1, ele.getPid());
			List<Person> list_person = query_person.getResultList();
			for (Person person_ele : list_person) {
				entityTransaction.begin();
				entityManager.remove(person_ele);
				entityManager.remove(ele);
				entityTransaction.commit();
			}
		}

	}

}
