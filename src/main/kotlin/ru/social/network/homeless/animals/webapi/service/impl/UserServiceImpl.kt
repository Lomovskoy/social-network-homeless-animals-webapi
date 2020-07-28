package ru.social.network.homeless.animals.webapi.service.impl

import org.springframework.stereotype.Service
import ru.social.network.homeless.animals.webapi.model.User
import ru.social.network.homeless.animals.webapi.repository.UserRepository
import ru.social.network.homeless.animals.webapi.service.UserService
import java.util.*

@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {

    override fun getUser(userId: UUID): Optional<User> {
        return userRepository.findById(userId)
    }

    override fun getUsers(userIds: Set<UUID>): List<User> {
        return userRepository.findAllById(userIds)
    }

    override fun createUser(user: User): User {
        return userRepository.save(user)
    }

    override fun editUser(user: User): User {
        return userRepository.save(user)
    }

    override fun deleteUser(userId: UUID) {
        return userRepository.deleteById(userId)
    }


}