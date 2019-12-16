package ru.azhd.petro.elastictest.configuration.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class Router {

    @Bean
    fun mainRouter(handlers: IElkHttpHandler): RouterFunction<ServerResponse> =
            router {
                POST("news/index/create", contentType(MediaType.APPLICATION_XML))
                { request -> handlers.createIndex(request) }
                POST("news/index/create-bulk", contentType(MediaType.APPLICATION_XML))
                { request -> handlers.createIndexBulk(request) }
            }

}