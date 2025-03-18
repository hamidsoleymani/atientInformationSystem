package com.boostmedia.patientinformationsystem.medicalfacility;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;

import static com.boostmedia.patientinformationsystem.TestUtilities.addressDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class MedicalFacilityControllerTest {

    @Container
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:15"))
            .withDatabaseName("testdb")
            .withUsername("postgres")
            .withPassword("postgres");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private WebTestClient webTestClient;
   // @Test
    void createMedicalFacility() {
        MedicalFacilityDto dto = new MedicalFacilityDto(null, "zuericher Krankenhaus", addressDto);
        webTestClient.mutate()
                .responseTimeout((Duration.ofSeconds(30)) )
                .build()
                .post()
                .uri("/medicalfacilities/create")
                .bodyValue(dto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(MedicalFacilityDto.class)
                .returnResult()
                .getResponseBody();
    }
}
