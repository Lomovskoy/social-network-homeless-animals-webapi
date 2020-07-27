package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
data class Advertisement (

        @Id
        val id: UUID,

        val heading: String,

        val description: String,

        val address: String? = null,

        @OneToOne
        val animal: Animal,

        val date: LocalDateTime,

        @OneToOne
        val user: User,

        val isImportant: Boolean = false
)