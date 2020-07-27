package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.validation.constraints.Size

@Entity
data class Animal(

        @Id
        val id: UUID,

        @Size(max = 50, min = 3, message = "Вид животного должен быть от 3 до 50 символов")
        val species: String,

        @Size(max = 50, min = 5, message = "Порода животного должен быть от 5 до 50 символов")
        val breed: String? = null,

        @Size(max = 50, min = 3, message = "Кличка животного должен быть от 3 до 50 символов")
        val nickname: String? = null,

        val dateOfBirth: LocalDate? = null,

        @Size(max = 500, min = 3, message = "Описание животного должен быть от 3 до 500 символов")
        val description: String? = null,

        @OneToOne
        val user: User

)