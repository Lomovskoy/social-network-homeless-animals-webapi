package ru.social.network.homeless.animals.webapi.service.impl

import org.springframework.stereotype.Service
import ru.social.network.homeless.animals.webapi.model.Photo
import ru.social.network.homeless.animals.webapi.repository.PhotoRepository
import ru.social.network.homeless.animals.webapi.service.PhotoService
import java.util.*

@Service
class PhotoServiceImpl(val photoRepository: PhotoRepository) : PhotoService {

    override fun getPhoto(photoId: UUID): Optional<Photo> {
        return photoRepository.findById(photoId)
    }

    override fun getPhotos(photoIds: Set<UUID>): List<Photo> {
        return photoRepository.findAllById(photoIds)
    }

    override fun createPhoto(photo: Photo): Photo {
        return photoRepository.save(photo)
    }

    override fun editPhoto(photo: Photo): Photo {
        return photoRepository.save(photo)
    }

    override fun deletePhoto(photoId: UUID) {
        return photoRepository.deleteById(photoId)
    }
}