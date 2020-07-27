package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.validation.constraints.Size

@Entity
data class Advertisement (

        @Id
        val id: UUID,

        @Size(max = 50, min = 5, message = "Заголовок объявления должен быть от 5 до 50 символов")
        val heading: String,

        @Size(max = 1000, min = 10, message = "Текст объявления должен быть от 10 до 1000 символов")
        val description: String,

        @Size(max = 250, min = 10, message = "Адрес в объявлении должен быть от 10 до 250 символов")
        val address: String? = null,

        @OneToOne
        val animal: Animal,

        val date: LocalDateTime,

        @OneToOne
        val user: User,

        val isImportant: Boolean = false
)