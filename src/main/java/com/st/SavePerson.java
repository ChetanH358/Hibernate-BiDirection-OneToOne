package com.st;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePerson {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person_1 = new Person();
		person_1.setName("Lokesh");
		person_1.setAge(25);
		person_1.setGender("male");

		Person person_2 = new Person();
		person_2.setName("Ramesh");
		person_2.setAge(23);
		person_2.setGender("male");

		Person person_3 = new Person();
		person_3.setName("Ankita");
		person_3.setAge(22);
		person_3.setGender("female");

		Person person_4 = new Person();
		person_4.setName("supriya");
		person_4.setAge(23);
		person_4.setGender("female");

		Person person_5 = new Person();
		person_5.setName("Suresh");
		person_5.setAge(24);
		person_5.setGender("male");

		PANCard card_1 = new PANCard();
		card_1.setAddress("Bangalore");
		card_1.setPan_num("LOK5560");
		card_1.setPhno(9984732156l);

		PANCard card_2 = new PANCard();
		card_2.setAddress("Mysore");
		card_2.setPan_num("RAM5562");
		card_2.setPhno(9984732158l);

		PANCard card_3 = new PANCard();
		card_3.setAddress("Belgavi");
		card_3.setPan_num("ANK5564");
		card_3.setPhno(9984732160l);

		PANCard card_4 = new PANCard();
		card_4.setAddress("Mandya");
		card_4.setPan_num("SUP5566");
		card_4.setPhno(9984732162l);

		PANCard card_5 = new PANCard();
		card_5.setAddress("kolar");
		card_5.setPan_num("SUR5568");
		card_5.setPhno(9984732164l);

		person_1.setPan(card_1);
		person_2.setPan(card_2);
		person_3.setPan(card_3);
		person_4.setPan(card_4);
		person_5.setPan(card_5);

		card_1.setPerson(person_1);
		card_2.setPerson(person_2);
		card_3.setPerson(person_3);
		card_4.setPerson(person_4);
		card_5.setPerson(person_5);

		entityTransaction.begin();
		entityManager.persist(person_1);
		entityManager.persist(person_2);
		entityManager.persist(person_3);
		entityManager.persist(person_4);
		entityManager.persist(person_5);
		entityManager.persist(card_1);
		entityManager.persist(card_2);
		entityManager.persist(card_3);
		entityManager.persist(card_4);
		entityManager.persist(card_5);
		entityTransaction.commit();

	}

}
