package ru.social.network.homeless.animals.webapi.service.builders

import ru.social.network.homeless.animals.webapi.enum.Role
import ru.social.network.homeless.animals.webapi.model.Advertisement
import ru.social.network.homeless.animals.webapi.model.User
import java.time.Clock
import java.time.LocalDateTime

class UserBuilders {

    companion object {

        private lateinit var name: String
        private lateinit var email: String
        private lateinit var password: String
        private lateinit var favorites: Set<Advertisement>
        private lateinit var dateRegistration: LocalDateTime
        private lateinit var role: Set<Role>

        fun setName(name: String): Companion {
            this.name = name
            return this
        }

        fun setEmail(email: String): Companion {
            this.email = email
            return this
        }

        fun setPassword(password: String): Companion {
            this.password = password
            return this
        }

        fun setFavorites(favorites: Set<Advertisement>): Companion {
            this.favorites = favorites
            return this
        }

        fun setDateRegistration(clock: Clock): Companion {
            this.dateRegistration = LocalDateTime.now(clock)
            return this
        }

        fun setRole(role: Set<Role>): Companion {
            this.role = role
            return this
        }

        fun build(): User {
            return User(null, name, null, null, null, email,
                    null, null, null, LocalDateTime.now(), null, password,
                    favorites, role, true)
        }
    }
}