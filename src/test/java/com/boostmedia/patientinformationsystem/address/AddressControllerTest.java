package com.boostmedia.patientinformationsystem.address;

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

import static com.boostmedia.patientinformationsystem.TestUtilities.addressDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//Spring detects that you're testing a web application and sets up WebTestClient to use that running instance.
//Because @SpringBootTest(RANDOM_PORT) starts the full application including controllers, services, repositories, etc.
//Spring Boot injects WebTestClient with the correct base URL for the running app.
//@SpringBootTest → Loads the full Spring Boot context.
//@Testcontainers → Ensures Testcontainers starts before tests run.
//@Container → Manages the PostgreSQL container lifecycle.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//RANDOM_PORT starts the full application on a random port
@Testcontainers
public class AddressControllerTest {


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
    void testSaveAndGetAddress() {

        // Send POST request to save address
        AddressDto savedAddress = webTestClient.post()
                .uri("/address/create")
                .bodyValue(addressDto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(AddressDto.class)
                .returnResult()
                .getResponseBody();

        assertNotNull(savedAddress);
        assertNotNull(savedAddress.id());

        Long savedAddressId = savedAddress.id();

        // Send GET request to fetch address
        webTestClient.get()
                .uri("/address/" + savedAddressId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(AddressDto.class)
                .value(response -> {
                    assertNotNull(response);
                    assertEquals("USA", response.country());
                    assertEquals("New York", response.city());
                    assertEquals("5th Avenue", response.street());
                    assertEquals("10128", response.zipCode());
                    assertEquals("10001", response.buildingNr());
                });
    }
/*
    @Autowired
    private TestRestTemplate restTemplate;
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
 */
}
