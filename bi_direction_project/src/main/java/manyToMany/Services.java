package manyToMany;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Services {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction et = em.getTransaction();
	public void updateTrainer(int id, String Subjectname, String newTrainerName) {
		Student student = em.find(Student.class, id);
		List<Subject>list = student.getSubjectList();
		for(Subject s:list) {
			if(s.getName().equals(Subjectname)) {
				s.setTrainer(newTrainerName);
				et.begin();
				em.merge(s);
				em.merge(student);
				et.commit();
				break;
			}
		}
	}
	public void fetch(int id) {
		Student student = em.find(Student.class, id);
		List<Subject>list = student.getSubjectList();
		System.out.println("Student - ");
		System.out.println("Id = "+student.getId());
		System.out.println("Name = "+student.getName());
		System.out.println("Subjects -");
		for(Subject s:list) {
			System.out.println("Id = "+s.getId());
			System.out.println("Name = "+s.getName());
			System.out.println("Trainer = "+s.getTrainer());
		}
	}
}
