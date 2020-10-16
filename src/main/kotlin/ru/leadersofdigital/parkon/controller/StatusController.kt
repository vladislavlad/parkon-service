package ru.leadersofdigital.parkon.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.leadersofdigital.parkon.model.StatusDto

@RestController
@RequestMapping("/api/status")
class StatusController {

    @GetMapping
    fun status(): StatusDto {
        return StatusDto("Parkon is on", true)
    }
}
