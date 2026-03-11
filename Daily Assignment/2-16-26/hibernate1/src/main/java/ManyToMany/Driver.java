package ManyToMany;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class Driver {   
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	public static void main(String[] args) {
		 
		/*Subject s1 = new Subject(101,"java","Ravi");
		Subject s2 = new Subject(102,"sql","Vaishnav");
		List<Subject>subjects = Arrays.asList(s1,s2);
		Student st1 = new Student(7,"Arifus",214343);
		Student st2 = new Student(8,"Natsu",33223);
		List<Student>students = Arrays.asList(st1,st2);
		s1.setStudentList(students);
		s2.setStudentList(students);
		//st1.setSubjectList(subjects);
		//st2.setSubjectList(subjects);
		et.begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(st1);
		em.persist(st2);
		et.commit();*/
	}
}