package ru.azhd.petro.elastictest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ElasticTestApplication

fun main(args: Array<String>) {
	runApplication<ElasticTestApplication>(*args)
}
