package ru.leadersofdigital.parkon.service

import org.modelmapper.ModelMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.leadersofdigital.parkon.model.Space
import ru.leadersofdigital.parkon.model.SpaceDto
import ru.leadersofdigital.parkon.repository.SpaceRepository

@Service
class SpaceServiceImpl(private val repo: SpaceRepository,
                       mapper: ModelMapper
) : WithTransformationService<Space, SpaceDto, SpaceDto>(mapper), SpaceService {

    override fun getList(id: Long, page: Pageable): Page<SpaceDto> {
        return repo.findByParkId(id, page)
            .map { s -> toDto<SpaceDto>(s) }
    }
}