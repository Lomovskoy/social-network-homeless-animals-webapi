package ru.social.network.homeless.animals.webapi.service.auth

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.social.network.homeless.animals.webapi.repository.UserRepository

@Service
class UserAuthenticationService(val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmailAndActiveTrue(email)
        if (user.isEmpty) throw UsernameNotFoundException("User not found")

        val authorities = user.get().role.map { role -> SimpleGrantedAuthority(role.name) }
        return User(user.get().name, user.get().password, authorities)
    }
}