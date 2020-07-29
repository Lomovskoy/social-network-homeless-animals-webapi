package ru.social.network.homeless.animals.webapi.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Clock
import java.time.ZoneId

@Configuration
class ClockConfig {

    private val log = LoggerFactory.getLogger(ClockConfig::class.java)

    @Value("\${time.zone}")
    private lateinit var timeZone: String

    @Bean
    fun clock(): Clock? {
        logInit(timeZone)
        return Clock.system(ZoneId.of(timeZone))
    }

    private fun logInit(clock: String?) {
        log.info(String.format("Clock config: timeZone = %s", clock))
    }
}