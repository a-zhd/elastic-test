package ru.azhd.petro.elastictest.configuration.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.azhd.petro.elastictest.service.IIndexService

@Configuration
class WebConfiguration {

    @Autowired
    private lateinit var indexService: IIndexService

//    @Bean
//    fun objectMapper(): ObjectMapper {
//        val mapper = XmlMapper()
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//        return mapper
//    }

//    @Bean
//    fun appHttpHandler(): IHttpHandler = HttpHandler(indexService)

}