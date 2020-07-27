package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Size

@Entity
data class User(

        @Id
        val id: UUID,

        @Size(max = 50, min = 3, message = "Имя пользователя должно быть от 3 до 50 символов")
        val name: String,

        @Size(max = 50, min = 3, message = "Фамилия пользователя должен быть от 3 до 50 символов")
        val surname: String? = null,

        @Size(max = 50, min = 3, message = "Отчество пользователя должно быть от 3 до 50 символов")
        val patronymic: String? = null,

        @Size(max = 15, min = 2, message = "Телефон пользователя должен быть от 2 до 15 символов")
        val phone: String? = null,

        @Email(message = "Некорректный email")
        val email: String,

        @Size(max = 250, min = 10, message = "Адрес пользователя должен быть от 10 до 250 символов")
        val address: String? = null,

        @Max(1, message = "Пол должен быть представлен одним символом")
        val sex: Char? = null,

        val dateOfBirth: LocalDateTime? = null,

        val dateRegistration: LocalDateTime? = null,

        @Email(message = "Некорректный email")
        val workEmail: String? = null,

        @Size(max = 50, min = 7, message = "Пароль пользователя должен быть от 7 до 50 символов")
        val password: String,

        @Size(max = 10, min = 20, message = "Соль пользователя должна быть от 10 до 20 символов")
        val salt: String,

        @ManyToMany
        val favorites: Set<Advertisement>

)