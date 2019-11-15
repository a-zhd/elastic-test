package ru.azhd.petro.elastictest.support.xml

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.xml.bind.annotation.adapters.XmlAdapter

class LocalDateTimeAdapter: XmlAdapter<String, LocalDateTime>() {

    private val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    override fun unmarshal(stringTime: String?): LocalDateTime {
        return LocalDateTime.parse(stringTime, pattern)
    }

    override fun marshal(localDateTime: LocalDateTime?): String {
        if (localDateTime != null) {
            return localDateTime.format(pattern)
        }
        return ""
    }
}