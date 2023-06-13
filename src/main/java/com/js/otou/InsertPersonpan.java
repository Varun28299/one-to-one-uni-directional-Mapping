package com.js.otou;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertPersonpan {
public static void main(String[] args) {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("varun");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et= em.getTransaction();
	
	Person p=new Person();
	p.setName("sohan");
	p.setEmail("sohan@456");
	p.setPhone(757654623l);
	
	
    Pan pan=new Pan();
	pan.setPan_no("743245vcbch");
	pan.setAddress("24,mfh layout,mysuru");
	
	p.setPan(pan);//pan object is passed to person.(if we dont do this the pan id column which is generated as foreignkey will be null and it will be waste because we did all this to achive relation between them )
	
	et.begin();
	em.persist(p);
	em.persist(pan);
	et.commit();
	System.out.println("Done");
	
	
	
	
}
}
