package ru.azhd.petro.elastictest

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.FileUrlResource
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ElasticIntegrationTest {

	@Autowired
	private lateinit var webTestClient: WebTestClient

	@Test
	fun contextLoads() {
		val xmlUrl = this.javaClass.getResource("/xml/test_item_1.xml")
		webTestClient.post()
				.uri("news/index/create")
				.contentType(MediaType.APPLICATION_XML)
				.body(BodyInserters.fromResource(FileUrlResource(xmlUrl)))
				.exchange()
				.expectStatus().isOk
				.expectBody()
				.jsonPath("$.message")
				.value<String> { println(it) }
	}

}
