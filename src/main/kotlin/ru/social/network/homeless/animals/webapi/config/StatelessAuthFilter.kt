package ru.social.network.homeless.animals.webapi.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import ru.social.network.homeless.animals.webapi.service.auth.TokenAuthService
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

@Configuration
class StatelessAuthFilter(val tokenAuthService : TokenAuthService) : GenericFilterBean() {

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        SecurityContextHolder.getContext().authentication =
                tokenAuthService.getAuthentication(request as HttpServletRequest).orElse(null)
        chain.doFilter(request, response)
    }
}