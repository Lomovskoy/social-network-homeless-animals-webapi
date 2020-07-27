package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class User(

        @Id
        val id: UUID,

        val name: String,

        val surname: String? = null,

        val patronymic: String? = null,

        val phone: String? = null,

        val email: String,

        val address: String? = null,

        val sex: Char? = null,

        val dateOfBirth: LocalDateTime? = null,

        val dateRegistration: LocalDateTime? = null,

        val image: String,

        val workEmail: String? = null,

        val password: String,

        val salt: String,

        @ManyToMany
        val favorites: Set<Advertisement>

)