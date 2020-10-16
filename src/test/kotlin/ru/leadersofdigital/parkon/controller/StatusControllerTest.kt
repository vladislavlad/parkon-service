package ru.leadersofdigital.parkon.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import ru.leadersofdigital.parkon.model.StatusDto


@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class StatusControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    companion object {
        @Container
        val postgres = PostgreSQLContainer<Nothing>("postgres:13.0-alpine")
            .apply {
                withDatabaseName("parkon")
                withUsername("parkon")
                withPassword("parkon")
            }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgres::getJdbcUrl);
            registry.add("spring.datasource.password", postgres::getPassword);
            registry.add("spring.datasource.username", postgres::getUsername);
        }
    }

    @Test
    fun statusTest() {
        val entity = restTemplate.getForEntity<StatusDto>("/api/status")

        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)

        val status = entity.body
        assertThat(status?.up).isEqualTo(true)
    }
}
