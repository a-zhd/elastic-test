package ru.azhd.petro.elastictest.model

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement


@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.FIELD)
class Rss {
    var channel: Channel = Channel()
}

@XmlRootElement(name = "channel")
@XmlAccessorType(XmlAccessType.FIELD)
class Channel {
    var items: List<NewsItem> = emptyList()
}

//@XmlRootElement(name = "item")
//@XmlAccessorType(XmlAccessType.FIELD)
@JacksonXmlRootElement(localName = "item")
@Document(indexName = "news-item", type = "news-item")
class NewsItem {
//    @XmlElement(name = "NewsID")
    @JacksonXmlProperty(localName = "NewsID")
    @Id
    var newsId: Long = 0

//    @XmlElement(name = "MediaID")
    @JacksonXmlProperty(localName = "MediaID")
    var mediaId: Long = 0

//    @XmlElement(name = "newsTitle")
    @JacksonXmlProperty
    val newsTitle: String? = null

//    @XmlElement(name = "newsText")
    @JacksonXmlProperty
    val newsText: String? = null

//    @XmlElement(name = "pubDate")
    @JacksonXmlProperty
    val pubDate: String? = null

//    @XmlElement(name = "insertDate")
    @JacksonXmlProperty
    val insertDate: String? = null

//        @XmlElement(name="pubDate")
//        @XmlJavaTypeAdapter(LocalDateTimeAdapter::class)
//        val pubDate: LocalDateTime? = null

//        @XmlElement(name="insertDate")
//        @XmlJavaTypeAdapter(LocalDateTimeAdapter::class)
//        val insertDate: LocalDateTime? = null
}