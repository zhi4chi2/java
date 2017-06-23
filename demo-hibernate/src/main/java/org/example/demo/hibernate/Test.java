package org.example.demo.hibernate;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Person person = new Person();
        person.name = "测试人";
        em.persist(person);
        em.getTransaction().commit();

        em.close();
        factory.close();
    }

    @Entity(name = "Person")
    public static class Person {
        @Id
        @GeneratedValue
        Integer id;
        String name;
    }
}