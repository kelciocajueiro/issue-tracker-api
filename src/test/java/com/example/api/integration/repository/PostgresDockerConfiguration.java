package com.example.api.integration.repository;

import com.example.api.infra.PostgresContainer;
import org.junit.ClassRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.shaded.com.google.common.base.Preconditions;

/**
 * Initializes the Container and set application properties
 * from the Container to the Spring context
 */
@SpringBootTest
abstract class PostgresDockerConfiguration {

    @ClassRule
    public static PostgresContainer container = PostgresContainer.getInstance();

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {

        Preconditions.checkState(container.isRunning(), "PostgresContainer must be started first");

        String postgresUri = String.format(
                "jdbc:postgresql://%s:%d/ccapi", container.getHost(), container.getMappedPort(5432));

        registry.add("spring.datasource.url", () -> postgresUri);
        registry.add("spring.datasource.username", () -> container.getUsername());
        registry.add("spring.datasource.password", () -> container.getPassword());
    }

}
