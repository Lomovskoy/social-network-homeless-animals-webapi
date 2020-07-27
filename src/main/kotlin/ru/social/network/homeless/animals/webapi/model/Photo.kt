package ru.social.network.homeless.animals.webapi.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

data class Photo (

        @Id
        val id: UUID,

        @ManyToOne
        val animal: Animal,

        val description: String? = null,

        val name: String,

        val ext: String,

        val filePath: String,

        val creteDate: LocalDateTime
)