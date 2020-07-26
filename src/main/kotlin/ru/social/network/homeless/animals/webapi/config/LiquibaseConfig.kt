package ru.social.network.homeless.animals.webapi.config

import liquibase.integration.spring.SpringLiquibase
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class LiquibaseConfig {

    private val logger = LoggerFactory.getLogger(LiquibaseConfig::class.java)

    @Autowired
    private lateinit var dataSource: DataSource

    @Value("\${spring.liquibase.change-log}")
    private lateinit var liquibaseChangeLogPath: String

    @Bean
    fun liquibase(): SpringLiquibase? {
        val liquibase = SpringLiquibase()
        liquibase.changeLog = liquibaseChangeLogPath
        liquibase.dataSource = dataSource
        liquibase.defaultSchema = dataSource.connection?.schema
        liquibase.isDropFirst = false
        liquibase.liquibaseSchema = dataSource.connection?.schema
        logPreInit(liquibase)
        return liquibase
    }

    private fun logPreInit(liquibase: SpringLiquibase) {
        logger.info("LiquibaseConfig initialized: [ dataSource = ${liquibase.dataSource}, " +
                "changeLogPath = ${liquibase.changeLog}, defaultSchema = ${liquibase.defaultSchema} ]")
    }
}