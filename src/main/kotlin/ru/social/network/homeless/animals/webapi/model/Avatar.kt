package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.validation.constraints.Size

@Entity
data class Avatar (

        @Id
        val id: UUID,

        @OneToOne
        val user: User,

        @Size(max = 250, min = 1, message = "Имя аватара должно быть от 1 до 250 символов")
        val name: String,

        @Size(max = 3, min = 3, message = "Формат аватара должно быть 3 символа")
        val ext: String,

        @Size(max = 36, min = 36, message = "Путь к аватара должно быть 36 символов")
        val filePath: String,

        val creteDate: LocalDateTime
)