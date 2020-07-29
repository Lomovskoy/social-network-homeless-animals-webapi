package ru.social.network.homeless.animals.webapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.social.network.homeless.animals.webapi.model.User
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, UUID> {
    fun findByEmailAndActiveTrue(email: String): Optional<User>
}