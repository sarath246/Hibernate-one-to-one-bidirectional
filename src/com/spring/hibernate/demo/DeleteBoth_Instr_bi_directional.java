package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Instructor;
import com.spring.hibernate.entity.InstructorDetail;

public class DeleteBoth_Instr_bi_directional {

	public static void main(String[] args) {

		// create session factory
		
		SessionFactory factory = new Configuration()
				
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			
			// get the instructor detail object
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			
			// print the instructor details
			System.out.println("Instructor detail :" + tempInstructorDetail);
			
			
			// print the associated instructor
			System.out.println("Associated instructor :" + tempInstructorDetail.getInstructor());
			
			
			// delete the instructor detail object
			System.out.println("deleting..." + tempInstructorDetail);
			
			session.delete(tempInstructorDetail);
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Success...");
			
		} finally {
			
			session.close();
			factory.close();
		}
		
	}

}
