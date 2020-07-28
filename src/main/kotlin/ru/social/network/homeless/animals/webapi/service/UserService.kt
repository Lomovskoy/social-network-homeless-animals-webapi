package ru.social.network.homeless.animals.webapi.service

import ru.social.network.homeless.animals.webapi.model.User
import java.util.*

interface UserService {

    fun getUser(userId: UUID): Optional<User>

    fun getUsers(userIds: Set<UUID>): List<User>

    fun createUser(user: User): User

    fun editUser(user: User): User

    fun deleteUser(userId: UUID)
}