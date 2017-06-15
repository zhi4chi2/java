package org.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Person person = new Person();
        person.setName("测试人");
        em.persist(person);
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}