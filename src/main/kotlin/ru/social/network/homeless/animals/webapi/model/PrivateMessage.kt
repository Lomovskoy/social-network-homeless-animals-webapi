package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.Size

@Entity
data class PrivateMessage(

        @Id
        val id: UUID,

        @Size(max = 5000, min = 1, message = "Текст сообщение должен быть от 1 до 5000 символов")
        val text: String,

        val date: LocalDateTime,

        @ManyToOne
        val sender: User,

        @ManyToOne
        val recipient: User
)