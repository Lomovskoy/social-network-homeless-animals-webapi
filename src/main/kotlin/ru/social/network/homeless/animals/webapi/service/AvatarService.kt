package ru.social.network.homeless.animals.webapi.service

import ru.social.network.homeless.animals.webapi.model.Avatar
import java.util.*

interface AvatarService {

    fun getAvatar(avatarId: UUID): Optional<Avatar>

    fun getAvatars(avatarIds: Set<UUID>): List<Avatar>

    fun createAvatar(avatar: Avatar): Avatar

    fun editAvatar(avatar: Avatar): Avatar

    fun deleteAvatar(avatarId: UUID)
}