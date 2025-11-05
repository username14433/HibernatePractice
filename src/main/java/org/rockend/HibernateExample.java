package org.rockend;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.rockend.config.HibernateConfig;
import org.rockend.entity.Address;
import org.rockend.entity.FacultyType;
import org.rockend.entity.Group;
import org.rockend.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Objects;

public class HibernateExample {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();



            Group group = entityManager.find(Group.class, 3);
            entityManager.remove(group);


//            Group group = new Group("4111", FacultyType.IT);
//            Student student1 = new Student(18, "Popov1", "Viktor", "Ivanovich");
//            Student student2 = new Student(18, "Popov2", "Viktor", "Ivanovich");
//            Student student3 = new Student(18, "Popov3", "Viktor", "Ivanovich");
//            group.addStudentToGroup(student1);
//            group.addStudentToGroup(student2);
//            group.addStudentToGroup(student3);
//            entityManager.persist(group);




            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception caught, executing rollback...");
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }


        context.close();

    }
}
