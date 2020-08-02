package ru.social.network.homeless.animals.webapi.enum

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    USER {
        override fun getAuthority(): String {
            return name
        }
    },
    ADMIN {
        override fun getAuthority(): String {
            return name
        }
    }
}