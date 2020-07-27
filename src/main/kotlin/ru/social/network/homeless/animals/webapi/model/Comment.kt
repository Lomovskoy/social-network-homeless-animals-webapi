package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

@Entity
data class Comment (

        @Id
        val id: UUID,

        @OneToOne
        val user: User,

        @ManyToOne
        val advertisement: Advertisement,

        val description: String,

        val creteDate: LocalDateTime
)