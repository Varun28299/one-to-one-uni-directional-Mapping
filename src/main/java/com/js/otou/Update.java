package com.js.otou;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("varun");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et= em.getTransaction();
	
	Person p=em.find(Person.class, 3);
	if(p!=null) {
		p.setName("Vikas");
		p.setEmail("vikas@123");
		p.setPhone(76475786856l);
		
		Pan pan =p.getPan();
		if(pan!=null) {
			pan.setPan_no("HGYH677688");
			pan.setAddress("usbhsbjb");
		   
			et.begin();
			em.merge(p);
			em.merge(pan);
			et.commit();
		}
		else {
			et.begin();
			em.merge(p);
			et.commit();
			System.out.println("No pan available");
		}
	}else {
		System.out.println("no person with given id");
	}
}
}
