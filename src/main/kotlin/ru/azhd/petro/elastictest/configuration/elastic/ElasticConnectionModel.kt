package ru.azhd.petro.elastictest.configuration.elastic

import org.springframework.boot.context.properties.ConfigurationProperties
import kotlin.properties.Delegates

@ConfigurationProperties("elasticsearch")
class ElasticConnectionModel {

    lateinit var clustername: String

    lateinit var host: String

    var port by Delegates.notNull<Int>()

}