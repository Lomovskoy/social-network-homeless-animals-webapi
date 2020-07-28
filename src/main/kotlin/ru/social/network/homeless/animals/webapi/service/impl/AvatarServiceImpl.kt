package ru.social.network.homeless.animals.webapi.service.impl

import org.springframework.stereotype.Service
import ru.social.network.homeless.animals.webapi.model.Avatar
import ru.social.network.homeless.animals.webapi.repository.AvatarRepository
import ru.social.network.homeless.animals.webapi.service.AvatarService
import java.util.*

@Service
class AvatarServiceImpl(val avatarRepository: AvatarRepository) : AvatarService {

    override fun getAvatar(avatarId: UUID): Optional<Avatar> {
        return avatarRepository.findById(avatarId)
    }

    override fun getAvatars(avatarIds: Set<UUID>): List<Avatar> {
        return avatarRepository.findAllById(avatarIds)
    }

    override fun createAvatar(avatar: Avatar): Avatar {
        return avatarRepository.save(avatar)
    }

    override fun editAvatar(avatar: Avatar): Avatar {
        return avatarRepository.save(avatar)
    }

    override fun deleteAvatar(avatarId: UUID) {
        return avatarRepository.deleteById(avatarId)
    }
}