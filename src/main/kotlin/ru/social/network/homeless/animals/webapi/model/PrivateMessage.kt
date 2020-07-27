package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class PrivateMessage(

        @Id
        val id: UUID,

        val text: String,

        val date: LocalDateTime,

        @ManyToOne
        val sender: User,

        @ManyToOne
        val recipient: User
)