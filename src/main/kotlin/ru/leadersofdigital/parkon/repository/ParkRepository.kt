package ru.leadersofdigital.parkon.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.leadersofdigital.parkon.model.Park

interface ParkRepository : JpaRepository<Park, Long>