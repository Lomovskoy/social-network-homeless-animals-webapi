package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(

        @Id
        var id: UUID,

        var name: String,

        var surname: String? = null,

        var patronymic: String? = null,

        var phone: String? = null,

        var email: String,

        var address: String? = null,

        var sex: Char? = null,

        var dateOfBirth: LocalDateTime? = null,

        var dateRegistration: LocalDateTime? = null,

        var image: String,

        var workEmail: String? = null,

        var password: String,

        var salt: String

) { constructor() }