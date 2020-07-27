package ru.social.network.homeless.animals.webapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AvatarRepository : JpaRepository<AvatarRepository, UUID>