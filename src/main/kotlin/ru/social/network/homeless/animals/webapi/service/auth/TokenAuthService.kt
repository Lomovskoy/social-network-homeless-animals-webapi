package ru.social.network.homeless.animals.webapi.service.auth

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import ru.social.network.homeless.animals.webapi.dto.UserAuthentication
import ru.social.network.homeless.animals.webapi.repository.UserRepository
import java.util.*
import javax.servlet.http.HttpServletRequest

@Service
class TokenAuthService(val tokenHandler: TokenHandler, val userRepository : UserRepository) {

    private val AUTH_HEADER_NAME = "X-Auth-Token"

    fun getAuthentication(request: HttpServletRequest): Optional<Authentication> {
        return Optional
                .ofNullable(request.getHeader(AUTH_HEADER_NAME))
                .flatMap { token -> tokenHandler.extractUserId(token) }
                .flatMap { id -> userRepository.findById(id) }
                .map { user -> UserAuthentication(user) }
    }
}