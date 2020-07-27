package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.Size

@Entity
data class Photo (

        @Id
        val id: UUID,

        @ManyToOne
        val animal: Animal,

        @Size(max = 500, min = 3, message = "Длинна описания фотографии должна быть от 1 до 500 символов")
        val description: String? = null,

        @Size(max = 250, min = 1, message = "Имя фотографии должно быть от 1 до 250 символов")
        val name: String,

        @Size(max = 3, min = 3, message = "Формат фотографии должно быть 3 символа")
        val ext: String,

        @Size(max = 36, min = 36, message = "Путь к аватара должно быть 36 символов")
        val filePath: String,

        val creteDate: LocalDateTime
)