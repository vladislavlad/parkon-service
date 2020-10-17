package ru.leadersofdigital.parkon.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.leadersofdigital.parkon.model.SpaceDto

interface SpaceService {

    fun getList(id: Long, page: Pageable) : Page<SpaceDto>
}