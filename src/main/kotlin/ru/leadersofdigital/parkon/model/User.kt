package ru.leadersofdigital.parkon.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "auth", name = "users")
data class User(
        var login: String,
        var pswd: String,
        var email: String,
        var blocked: Boolean = false,
        @Column(name = "email_confirmed")
        var emailConfirmed: Boolean = true,
        @ElementCollection(targetClass = Role::class)
        @Enumerated(EnumType.STRING)
        @CollectionTable(schema = "auth", name = "user_roles")
        @Column(name = "role")
        var roles: MutableList<Role>,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = roles
    override fun getUsername(): String = login
    override fun getPassword(): String = pswd
    override fun isEnabled(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
}
