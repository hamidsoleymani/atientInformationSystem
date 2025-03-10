package com.boostmedia.patientinformationsystem.address;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class AddressControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

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

    @Test
    void testSaveAndGetAddress() {
        AddressDto addressDto = new AddressDto(null, "USA", "New York", "5th Avenue", "10128", "10001");

        ResponseEntity<AddressDto> saveResponse = restTemplate.postForEntity("/address/create", addressDto, AddressDto.class);
        assertEquals(HttpStatus.OK, saveResponse.getStatusCode());
        assertNotNull(saveResponse.getBody());
        assertNotNull(saveResponse.getBody().id());

        Long savedAddressId = saveResponse.getBody().id();
        ResponseEntity<AddressDto> getResponse = restTemplate.getForEntity("/address/" + savedAddressId, AddressDto.class);

        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertNotNull(getResponse.getBody());
        assertEquals("USA", getResponse.getBody().country());
        assertEquals("New York", getResponse.getBody().city());
        assertEquals("5th Avenue", getResponse.getBody().street());
        assertEquals("10128", getResponse.getBody().zipCode());
        assertEquals("10001", getResponse.getBody().buildingNr());
    }
}
