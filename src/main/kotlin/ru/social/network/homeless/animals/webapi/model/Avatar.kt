package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
data class Avatar (

        @Id
        val id: UUID,

        @OneToOne
        val user: User,

        val name: String,

        val ext: String,

        val filePath: String,

        val creteDate: LocalDateTime
)