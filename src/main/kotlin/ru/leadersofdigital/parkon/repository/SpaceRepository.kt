package ru.leadersofdigital.parkon.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import ru.leadersofdigital.parkon.model.Space

interface SpaceRepository : JpaRepository<Space, Long> {

    fun findByParkId(parkId: Long, pageable: Pageable): Page<Space>
}