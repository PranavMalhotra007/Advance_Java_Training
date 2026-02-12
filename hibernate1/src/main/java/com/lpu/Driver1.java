package com.lpu;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver1 {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	public static void main(String[]args) {
		/*StudentServices services = new StudentServices();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the option to choose:"
				+ "\n1. Save and create student"
				+ "\n2. Update Phone no."
				+ "\n3. Update Name"
				+ "\n4. Find by Id"
				+ "\n5. Delete by Id"
				+ "\n6. Print Table"
				+ "\n7. Exit the Program");
		int option = sc.nextInt();
		while(option!=7) {
			int id;
			String name;
			long phone;
			switch(option) {
				case 1:
					System.out.println("Enter the id:-");
					id = sc.nextInt();
					System.out.println("Enter the name:-");
					name = sc.next();
					System.out.println("Enter the phone:-");
					phone = sc.nextLong();
					services.saveStudent(id, name, phone);
					break;
				case 2:
					System.out.println("Enter the id:-");
					id = sc.nextInt();
					System.out.println("Enter the phone:-");
					phone = sc.nextLong();
					services.updatePhone(id, phone);
					break;
				case 3:
					System.out.println("Enter the id:-");
					id = sc.nextInt();
					System.out.println("Enter the name:-");
					name = sc.next();
					services.updateName(id, name);
					break;
				case 4:
					System.out.println("Enter the id:-");
					id = sc.nextInt();
					services.findById(id);
					break;
				case 5:
					System.out.println("Enter the id:-");
					id = sc.nextInt();
					services.deleteById(id);
					break;
				case 6:
					services.ListOfAllStudents();
					break;
			}
			System.out.println("Enter the option: ");
			option = sc.nextInt();
		}
		System.out.println("Program Ended");
		sc.close();*/
	}
}