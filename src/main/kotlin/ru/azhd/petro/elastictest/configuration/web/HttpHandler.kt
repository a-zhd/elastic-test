package ru.azhd.petro.elastictest.configuration.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import ru.azhd.petro.elastictest.model.NewsItem
import ru.azhd.petro.elastictest.service.IIndexService

interface IHttpHandler {
    fun createIndex(serverRequest: ServerRequest): Mono<ServerResponse>
}

class HttpHandler(@Autowired val indexService: IIndexService): IHttpHandler {

    override fun createIndex(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(NewsItem::class.java)
                .map { t -> indexService.createIndex(t); t.newsId }
                .flatMap { newsId -> ServerResponse.ok().bodyValue(SuccessResponse("Success index create by newsId = $newsId")) }
                .onErrorResume { ServerResponse.badRequest().bodyValue(ErrorResponse(it?.message ?: "unknown error")) }
    }

}