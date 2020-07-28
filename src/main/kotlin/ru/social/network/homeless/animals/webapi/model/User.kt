package ru.social.network.homeless.animals.webapi.model

import ru.social.network.homeless.animals.webapi.enum.Role
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Size

@Entity
data class User(

        @Id
        val id: UUID = UUID.randomUUID(),

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

        @ManyToMany
        val favorites: Set<Advertisement> = setOf(),

        @Enumerated(EnumType.STRING)
        @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
        @CollectionTable(name = "user_role", joinColumns = [JoinColumn(name = "user_id")])
        val roles : Set<Role> = setOf(Role.USER),

        val active: Boolean = true

)