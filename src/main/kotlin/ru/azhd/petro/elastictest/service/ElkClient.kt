package ru.azhd.petro.elastictest.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.azhd.petro.elastictest.model.NewsItem
import ru.azhd.petro.elastictest.repository.INewsIndexRepository

interface IElkClient {
    fun save(newsItem: NewsItem)
    fun saveBulk(items: List<NewsItem>)
}

@Service
class ElkClient(@Autowired private val newsIndexRepository: INewsIndexRepository) : IElkClient {

    private companion object {
        val logger = LoggerFactory.getLogger(ElkClient::class.java)
    }

    override fun save(newsItem: NewsItem) {
        logger.info("Try save with newsId =  ${newsItem.newsId}")
//        newsIndexRepository.save(newsItem)

    }

    override fun saveBulk(items: List<NewsItem>) {
        logger.info("Try save with newsIds =  ${items.joinToString()}"
//        newsIndexRepository.saveAll(items)
        )
    }

}