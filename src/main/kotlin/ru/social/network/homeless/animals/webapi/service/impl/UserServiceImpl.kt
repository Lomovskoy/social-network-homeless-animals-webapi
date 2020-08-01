package ru.social.network.homeless.animals.webapi.service.impl

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.social.network.homeless.animals.webapi.dto.CreateUserDTO
import ru.social.network.homeless.animals.webapi.enum.Role
import ru.social.network.homeless.animals.webapi.model.User
import ru.social.network.homeless.animals.webapi.repository.UserRepository
import ru.social.network.homeless.animals.webapi.service.UserService
import ru.social.network.homeless.animals.webapi.service.builders.UserBuilders
import java.time.Clock
import java.util.*
import javax.validation.ValidationException

@Service
class UserServiceImpl(val userRepository: UserRepository, val clock: Clock, val passwordEncoder: PasswordEncoder) : UserService {

    override fun getUser(userId: UUID): User {
        return userRepository.findById(userId).orElseThrow()
    }

    override fun getUsers(userIds: Set<UUID>): List<User> {
        return userRepository.findAllById(userIds)
    }

    override fun createUser(createUserDTO: CreateUserDTO) {
        if (createUserDTO.password != createUserDTO.repeatedPassword) {
            throw ValidationException("Пароли должны совпадать")
        } else {
            userRepository.save(getUser(createUserDTO))
        }
    }

    override fun editUser(user: User): User {
        return userRepository.save(user)
    }

    override fun deleteUser(userId: UUID) {
        return userRepository.deleteById(userId)
    }

    private fun getUser(createUserDTO: CreateUserDTO) : User {
        return UserBuilders
                .setName(createUserDTO.name)
                .setEmail(createUserDTO.email)
                .setPassword(passwordEncoder.encode(createUserDTO.password))
                .setFavorites(setOf())
                .setDateRegistration(clock)
                .setRole(setOf(Role.USER))
                .build()
    }
}