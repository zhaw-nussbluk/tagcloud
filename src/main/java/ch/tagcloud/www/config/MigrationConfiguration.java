package ch.tagcloud.www.config;

/**
 * Flyway nach JPA laden. Link: https://stackoverflow.com/questions/37097876/spring-boot-hibernate-and-flyway-boot-order
 */

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class MigrationConfiguration {


    /**
     * Override default flyway initializer to do nothing
     */
    @Bean
    FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
        return new FlywayMigrationInitializer(flyway, (f) ->{} );
    }


    /**
     * Create a second flyway initializer to run after jpa has created the schema
     */
    @Bean
    @DependsOn("entityManagerFactory")
    FlywayMigrationInitializer delayedFlywayInitializer(Flyway flyway) {
        return new FlywayMigrationInitializer(flyway, null);
    }


}