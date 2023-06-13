package com.js.otou;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetAll {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("varun");
		EntityManager em=emf.createEntityManager();
		
		String query="select p from Person p";
		
		Query q=em.createQuery(query);
	    
		List<Person> persons=q.getResultList();
		
		if(!persons.isEmpty()) {
			for(Person p : persons) {
				System.out.println("Person Id= "+p.getId());
				System.out.println("Person name "+p.getName());
				System.out.println("Person email "+p.getEmail());
				System.out.println("Person phone "+p.getPhone());
				   
				Pan pan=p.getPan();
				if(pan!=null) {
					System.out.println("pan id "+pan.getId());
					System.out.println("pan no "+pan.getPan_no());
					System.out.println("pan address "+pan.getAddress());
				}
				else {
					System.out.println("Person has no pan");
				}
			}
		}
		else {
			System.out.println("No person available");
		}
	}
}
