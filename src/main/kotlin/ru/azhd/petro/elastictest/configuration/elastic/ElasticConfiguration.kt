package ru.azhd.petro.elastictest.configuration.elastic

import org.elasticsearch.client.Client
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.TransportAddress
import org.elasticsearch.transport.client.PreBuiltTransportClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import java.net.InetAddress


@Configuration
@EnableElasticsearchRepositories(basePackages = ["ru.azhd.petro.elastictest.repository"])
class ElasticConfiguration() {

    @Autowired
    private lateinit var elasticConnectionModel: ElasticConnectionModel

    @Bean
    fun client(): Client {
        val settings = Settings.builder()
                .put("cluster.name", elasticConnectionModel.clustername)
                .build()

        return PreBuiltTransportClient(settings)
                .addTransportAddress(
                        TransportAddress(
                                InetAddress.getByName(elasticConnectionModel.host), elasticConnectionModel.port
                        )
                )
    }

    @Bean
    fun elasticsearchTemplate(client: Client): ElasticsearchOperations = ElasticsearchTemplate(client)

}