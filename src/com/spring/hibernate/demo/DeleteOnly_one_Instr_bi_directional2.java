package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Instructor2;
import com.spring.hibernate.entity.InstructorDetail_Del_one_bi;

public class DeleteOnly_one_Instr_bi_directional2 {

	public static void main(String[] args) {

		// create session factory
		
		SessionFactory factory = new Configuration()
				
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor2.class)
								.addAnnotatedClass(InstructorDetail_Del_one_bi.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			
			// get the InstructorDetail_Del_one_bi object
			int theId = 5;
			InstructorDetail_Del_one_bi tempInstructorDetail = session.get(InstructorDetail_Del_one_bi.class, theId);
			
			
			// print the instructor details
			System.out.println("Instructor detail :" + tempInstructorDetail);
			
			
			// print the associated instructor
			System.out.println("Associated instructor :" + tempInstructorDetail.getInstructor());
			
			
			// remove the associated object refference
			// break bi-directional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			
			// delete the instructor detail object
			System.out.println("deleting..." + tempInstructorDetail);
			
			session.delete(tempInstructorDetail);
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Success...");
			
		}catch (Exception e) {

			e.printStackTrace();
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}

}
