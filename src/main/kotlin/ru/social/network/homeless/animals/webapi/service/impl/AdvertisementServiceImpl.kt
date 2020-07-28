package ru.social.network.homeless.animals.webapi.service.impl

import org.springframework.stereotype.Service
import ru.social.network.homeless.animals.webapi.model.Advertisement
import ru.social.network.homeless.animals.webapi.repository.AdvertisementRepository
import ru.social.network.homeless.animals.webapi.service.AdvertisementService
import java.util.*

@Service
class AdvertisementServiceImpl(val advertisementRepository: AdvertisementRepository) : AdvertisementService {

    override fun getAdvertisement(advertisementId: UUID): Optional<Advertisement> {
        return advertisementRepository.findById(advertisementId)
    }

    override fun getAdvertisements(advertisementIds: Set<UUID>): List<Advertisement> {
        return advertisementRepository.findAllById(advertisementIds)
    }

    override fun createAdvertisement(advertisement: Advertisement): Advertisement {
        return advertisementRepository.save(advertisement)
    }

    override fun editAdvertisement(advertisement: Advertisement): Advertisement {
        return advertisementRepository.save(advertisement)
    }

    override fun deleteAdvertisement(advertisementId: UUID) {
        return advertisementRepository.deleteById(advertisementId)
    }
}