package ru.leadersofdigital.parkon.model

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    DEFAULT;

    override fun getAuthority(): String = name
}
