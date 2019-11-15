package ru.azhd.petro.elastictest.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import ru.azhd.petro.elastictest.support.xml.LocalDateTimeAdapter
import java.time.LocalDateTime
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
@Document(indexName = "news-item", type = "news-item")
class NewsItem() {
        @XmlElement(name="NewsID")
        @Id
        var newsId: Long = 0

        @XmlElement(name="MediaID")
        var mediaId: Long = 0

        @XmlElement(name="newsTitle")
        val newsTitle: String? = null

        @XmlElement(name="newsText")
        val newsText: String? = null

        @XmlElement(name="pubDate")
        val pubDate: String? = null

        @XmlElement(name="insertDate")
        val insertDate: String? = null

//        @XmlElement(name="pubDate")
//        @XmlJavaTypeAdapter(LocalDateTimeAdapter::class)
//        val pubDate: LocalDateTime? = null

//        @XmlElement(name="insertDate")
//        @XmlJavaTypeAdapter(LocalDateTimeAdapter::class)
//        val insertDate: LocalDateTime? = null
}