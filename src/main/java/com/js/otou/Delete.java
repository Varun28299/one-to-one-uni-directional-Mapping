package com.js.otou;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("varun");
		EntityManager em= emf.createEntityManager();
	    EntityTransaction et=em.getTransaction();
	    
	    Person p= em.find(Person.class, 2);
	    if(p!=null) {           //find person then get pan if pan is there delete person and pan else delete person and print no pan
	    	
	    	Pan pan=p.getPan();{
	    		if(pan!=null) {
	    			et.begin();
	    	    	em.remove(p);
	    	    	em.remove(pan);
	    	    	et.commit();
	    	    	System.out.println("Deleted");
	           }
	    		else {
	    			et.begin();
	    			em.remove(p);
	    			et.commit();
	    			System.out.println("Person has No pan");
	    		    }
	    	}
	    }else {
		          System.out.println("No person in this id");
	           }
}
}
