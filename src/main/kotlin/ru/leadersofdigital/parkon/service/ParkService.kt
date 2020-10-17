package ru.leadersofdigital.parkon.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.leadersofdigital.parkon.model.ParkDto

interface ParkService {

    fun getList(page: Pageable) : Page<ParkDto>
}