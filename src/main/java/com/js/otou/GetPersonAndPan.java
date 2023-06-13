package com.js.otou;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetPersonAndPan {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("varun");
		EntityManager em=emf.createEntityManager();
		
		Person p=em.find(Person.class, 5); //here we are passing person id through person id i get pan details also because it(person table) has pan id as foreign key
		                                   //all the queries will be written by hibernate
		if(p!=null) {
			System.out.println("Person Id "+p.getId());    //we can generate tostring instead of writing print statements and here we can print reference
			System.out.println("Person Name "+p.getName());
			System.out.println("Person email "+p.getEmail());
			System.out.println("Person phone "+p.getPhone());
		   
			Pan pan=p.getPan();
			if(pan!=null) {
				System.out.println("pan id "+pan.getId());
				System.out.println("pan no "+pan.getPan_no());
				System.out.println("pan address "+pan.getAddress());
			}
			else {
				System.out.println("Person has No pan"); //if person has no pan id then this will execute
			}
		}
		else {
			System.out.println("No person with given Id");
		}
	}
}
