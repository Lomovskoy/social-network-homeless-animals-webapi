package ru.social.network.homeless.animals.webapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.social.network.homeless.animals.webapi.model.Advertisement
import java.util.*

@Repository
interface AdvertisementRepository : JpaRepository<Advertisement, UUID>