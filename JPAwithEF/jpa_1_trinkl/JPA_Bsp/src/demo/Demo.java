package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class Demo {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersonPU");
        EntityManager em = factory.createEntityManager();

        insertPerson(em);

        Query query = em.createQuery("select p from Person p");
        List<Person> result = query.getResultList();
        for (Person p : result){
            System.out.println(p.getsSSN() + ": " + p.getFirstName() + " " + p.getLastName());
        }

        em.close();
        factory.close();
    }

    private static void insertPerson(EntityManager em ){
        em.getTransaction().begin();
        Person newPerson = new Person();
        newPerson.setsSSN("5555050670");
        newPerson.setFirstName("Java");
        newPerson.setLastName("Student");
        newPerson.setDateOfBirth(Date.from(LocalDate.of(1970,6,5).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        newPerson.setAwesome(false);
        newPerson.setAwesomeness(-8.12);
        em.persist(newPerson);
        insertAddress(em, newPerson);
        em.getTransaction().commit();
    }

    private static void insertAddress(EntityManager em, Person newPerson) {
        Address newAddress = new Address();
        newAddress.setSSN("5555050670");
        newAddress.setAddressNo((short)1);
        newAddress.setCity("Linz");
        newAddress.setCountry("Austria");
        newAddress.setStreet("Main Street");
        newAddress.setStreetNo((short)1);
        newAddress.setPerson(newPerson);
        em.getTransaction().commit();
    }
}
