package ru.azhd.petro.elastictest.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.azhd.petro.elastictest.model.NewsItem
import ru.azhd.petro.elastictest.repository.NewsIndexRepository

interface IIndexService {
    fun createIndex(newsItem: NewsItem)
}

@Service
class IndexService(@Autowired private val newsIndexRepository: NewsIndexRepository) : IIndexService {
    override fun createIndex(newsItem: NewsItem) {
        newsIndexRepository.save(newsItem)
    }
}