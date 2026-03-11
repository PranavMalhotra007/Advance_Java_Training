package manyToMany;

//import java.util.List;

//import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
	public static void main(String[]args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		System.out.println(emf);
		/*EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Subject s1 = new Subject(1,"Java","Ravi");
		Subject s2 = new Subject(2,"SQL","Vaishnav");
		Student st1 = new Student(11,"Raju");
		Student st2 = new Student(12,"Ramu");
		List<Subject>subjectList = List.of(s1,s2);
		List<Student>studentList = List.of(st1,st2);
		s1.setStudentList(studentList);
		s2.setStudentList(studentList);
		st1.setSubjectList(subjectList);
		st2.setSubjectList(subjectList);
		et.begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(st1);
		em.persist(st2);
		et.commit();*/
		Services services= new Services();
		services.fetch(11);
		services.updateTrainer(11, "Java", "Striver");
		services.fetch(11);
		services.fetch(12);
	}
}
