package ru.leadersofdigital.parkon.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.leadersofdigital.parkon.model.User
import java.util.Optional

@Repository
interface UserRepo : JpaRepository<User, Long> {

    fun findByLogin(login: String): Optional<User>
}