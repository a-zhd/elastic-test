package ru.azhd.petro.elastictest.configuration.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import ru.azhd.petro.elastictest.model.NewsItem
import ru.azhd.petro.elastictest.model.Rss
import ru.azhd.petro.elastictest.service.IIndexService

interface IElkHttpHandler {
    fun createIndex(serverRequest: ServerRequest): Mono<ServerResponse>
    fun createIndexBulk(serverRequest: ServerRequest): Mono<ServerResponse>
}

@Component
class ElkHttpHandler(@Autowired val indexService: IIndexService) : IElkHttpHandler {

    override fun createIndex(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(NewsItem::class.java)
                .map { newsItem ->
                    indexService.createIndex(newsItem)
                    newsItem.newsId
                }
                .flatMap { newsId ->
                    ServerResponse.ok()
                            .bodyValue(SuccessResponse("Success index create by newsId = $newsId")) }
                .onErrorResume { ServerResponse.badRequest().bodyValue(ErrorResponse(it?.message ?: "unknown error")) }
    }

    override fun createIndexBulk(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(Rss::class.java)
                .map { rss ->
                    indexService.createIndexBulk(rss)
                    rss.channel.items.joinToString()
                }
                .flatMap { newsIds ->
                    ServerResponse.ok()
                            .bodyValue(SuccessResponse("Success index create by newsIds = $newsIds"))
                }
                .onErrorResume { ServerResponse.badRequest().bodyValue(ErrorResponse(it?.message ?: "unknown error")) }
    }

    data class SuccessResponse(val message: String)
    data class ErrorResponse(val error: String)

}