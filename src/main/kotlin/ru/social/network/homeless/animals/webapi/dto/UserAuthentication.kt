package ru.social.network.homeless.animals.webapi.dto

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import ru.social.network.homeless.animals.webapi.model.User

class UserAuthentication(private val user: User) : Authentication {

    private var authenticated = false

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return user.role
    }

    override fun setAuthenticated(isAuthenticated: Boolean) {
        authenticated = isAuthenticated
    }

    override fun getName(): String {
        return user.email
    }

    override fun getCredentials(): Any {
        return user.password
    }

    override fun getPrincipal(): Any {
        return user
    }

    override fun isAuthenticated(): Boolean {
        return authenticated
    }

    override fun getDetails(): Any {
        return user.name
    }
}