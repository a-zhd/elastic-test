package ru.azhd.petro.elastictest.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.azhd.petro.elastictest.model.Rss
import ru.azhd.petro.elastictest.model.NewsItem
import ru.azhd.petro.elastictest.repository.INewsIndexRepository

interface IIndexService {
    fun createIndex(newsItem: NewsItem)
    fun createIndexBulk(rss: Rss)
}

@Service
class IndexService(@Autowired private val elkClient: IElkClient) : IIndexService {
    override fun createIndex(newsItem: NewsItem) {
        elkClient.save(newsItem)
    }

    override fun createIndexBulk(rss: Rss) {
        elkClient.saveBulk(rss.channel.items)
    }
}