package ru.leadersofdigital.parkon.controller

import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.leadersofdigital.parkon.model.SpaceDto
import ru.leadersofdigital.parkon.service.SpaceService

@RestController
@RequestMapping("/api/parks/{parkId}/space")
class SpaceController(private val service: SpaceService) {

    @GetMapping
    fun list(@PathVariable parkId: Long,
             @RequestParam(defaultValue = "0") page: Int,
             @RequestParam(defaultValue = "20") size: Int): List<SpaceDto> {
        val pageRequest = PageRequest.of(page, size)

        return service.getList(parkId, pageRequest).content
    }
}
