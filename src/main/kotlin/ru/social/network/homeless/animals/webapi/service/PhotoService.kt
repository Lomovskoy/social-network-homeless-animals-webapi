package ru.social.network.homeless.animals.webapi.service

import ru.social.network.homeless.animals.webapi.model.Photo
import java.util.*

interface PhotoService {

    fun getPhoto(photoId: UUID): Optional<Photo>

    fun getPhotos(photoIds: Set<UUID>): List<Photo>

    fun createPhoto(photo: Photo): Photo

    fun editPhoto(photo: Photo): Photo

    fun deletePhoto(photoId: UUID)
    
}