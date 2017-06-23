package org.example.demo.flyway;

import org.flywaydb.core.Flyway;

public class Test {
    public static void main(String[] args) {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:postgresql://localhost:5432/test", "postgres", "postgres");
        flyway.migrate();
    }
}
