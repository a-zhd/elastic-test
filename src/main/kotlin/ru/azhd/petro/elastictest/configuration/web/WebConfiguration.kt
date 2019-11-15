package ru.azhd.petro.elastictest.configuration.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import ru.azhd.petro.elastictest.service.IIndexService

@Configuration
class WebConfiguration {

    @Autowired
    private lateinit var indexService: IIndexService

    @Bean
    fun router(handlers: IHttpHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
                .route(POST("news/index/create").and(contentType(MediaType.APPLICATION_XML)),
                        HandlerFunction { request -> handlers.createIndex(request) })
    }

    @Bean
    fun handlers(): IHttpHandler = HttpHandler(indexService)

}