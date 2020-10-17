package ru.leadersofdigital.parkon.controller

import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.leadersofdigital.parkon.model.ParkDto
import ru.leadersofdigital.parkon.service.ParkService

@RestController
@RequestMapping("/api/parks")
class ParkController(val service: ParkService) {

    @GetMapping
    fun list(@RequestParam(defaultValue = "0") page: Int,
             @RequestParam(defaultValue = "20") size: Int): List<ParkDto> {
        return service.getList(PageRequest.of(page, size)).content
    }
}