package ru.social.network.homeless.animals.webapi.dto

import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class CreateUserDTO (

        @Size(max = 50, min = 3, message = "Имя пользователя должно быть от 3 до 50 символов")
        val name: String,

        @Email(message = "Некорректный email")
        val email: String,

        @Size(max = 50, min = 7, message = "Пароль пользователя должен быть от 7 до 50 символов")
        val password: String,

        @Size(max = 50, min = 7, message = "Пароль пользователя должен быть от 7 до 50 символов")
        val repeatedPassword: String
)