package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
data class Animal(

        @Id
        val id: UUID,

        val species: String,

        val breed: String? = null,

        val nickname: String? = null,

        val dateOfBirth: LocalDate? = null,

        val description: String? = null,

        @OneToOne
        val user: User

)