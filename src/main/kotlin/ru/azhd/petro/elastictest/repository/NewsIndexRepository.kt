package ru.azhd.petro.elastictest.repository

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import ru.azhd.petro.elastictest.model.NewsItem

interface NewsIndexRepository: ElasticsearchRepository<NewsItem, Long>