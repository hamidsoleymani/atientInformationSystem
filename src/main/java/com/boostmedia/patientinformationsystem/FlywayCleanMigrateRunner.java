package com.boostmedia.patientinformationsystem;

import org.flywaydb.core.Flyway;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FlywayCleanMigrateRunner implements ApplicationRunner {

    private final Flyway flyway;

    public FlywayCleanMigrateRunner(Flyway flyway) {
        this.flyway = flyway;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        flyway.clean(); // Clean the databasejenkins test6
        flyway.migrate(); // Apply migrations
    }
}
