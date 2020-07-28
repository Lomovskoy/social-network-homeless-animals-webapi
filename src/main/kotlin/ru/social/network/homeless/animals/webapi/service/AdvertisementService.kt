package ru.social.network.homeless.animals.webapi.service

import ru.social.network.homeless.animals.webapi.model.Advertisement
import java.util.*

interface AdvertisementService {

    fun getAdvertisement(advertisementId: UUID): Optional<Advertisement>

    fun getAdvertisements(advertisementIds: Set<UUID>): List<Advertisement>

    fun createAdvertisement(advertisement: Advertisement): Advertisement

    fun editAdvertisement(advertisement: Advertisement): Advertisement

    fun deleteAdvertisement(advertisementId: UUID)

}