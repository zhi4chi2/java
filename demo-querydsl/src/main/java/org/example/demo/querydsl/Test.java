package org.example.demo.querydsl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QCustomer customer = QCustomer.customer;
        Customer bob = queryFactory.selectFrom(customer).where(customer.firstName.eq("Bob")).fetchOne();
        System.out.println(bob);

        em.close();
        emf.close();
    }
}
