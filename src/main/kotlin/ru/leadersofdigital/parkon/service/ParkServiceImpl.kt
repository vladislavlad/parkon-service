package ru.leadersofdigital.parkon.service

import org.modelmapper.ModelMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.leadersofdigital.parkon.model.Park
import ru.leadersofdigital.parkon.model.ParkDto
import ru.leadersofdigital.parkon.repository.ParkRepository

@Service
class ParkServiceImpl(
        private val repo: ParkRepository,
        mapper: ModelMapper
) : WithTransformationService<Park, ParkDto, ParkDto>(mapper), ParkService {

    override fun getList(page: Pageable): Page<ParkDto> {
        return repo.findAll(Pageable.unpaged())
            .map { p -> toDto<ParkDto>(p) }
    }
}