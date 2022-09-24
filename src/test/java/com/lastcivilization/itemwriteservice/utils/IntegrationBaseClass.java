package com.lastcivilization.itemwriteservice.utils;

import com.lastcivilization.itemwriteservice.infrastructure.application.ItemWriteServiceApplication;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(classes = ItemWriteServiceApplication.class, webEnvironment = RANDOM_PORT, properties = "test.url=http://localhost:9561")
@Testcontainers
@AutoConfigureMockMvc
public class IntegrationBaseClass {

    @Container
    private static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:14-alpine")
            .withDatabaseName("test");

    @Autowired
    protected ItemCreator itemCreator;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @DynamicPropertySource
    private static void init(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", () -> "jdbc:tc:postgresql:14-alpine:///test");
        registry.add("eureka.client.register-with-eureka", () -> "false");
        registry.add("eureka.client.fetch-registry", () -> "false");
    }

    @BeforeEach
    void restTestStats(){
        itemCreator.resetTestItemDetails();
    }
}
