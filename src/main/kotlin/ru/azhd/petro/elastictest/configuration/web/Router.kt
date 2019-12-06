package ru.azhd.petro.elastictest.configuration.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import ru.azhd.petro.elastictest.service.IIndexService

@Configuration
class Router {

    @Autowired
    private lateinit var indexService: IIndexService

    @Bean
    fun mainRouter(handlers: IHttpHandler): RouterFunction<ServerResponse> =
            router {
                POST("news/index/create", contentType(MediaType.APPLICATION_XML))
                { request -> handlers.createIndex(request) }
                POST("news/index/create-bulk", contentType(MediaType.APPLICATION_XML))
                { request -> handlers.createIndexBulk(request) }
            }

    @Bean
    fun handlers(): IHttpHandler = HttpHandler(indexService)
}